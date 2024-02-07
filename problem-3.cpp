// 702. Search in a Sorted Array of Unknown Size
// Time Complexity : O(n)
// Space Complexity : 1
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach in three sentences only
// since the size of the array is unknown we will take two pointers low and high at zeroth and first index respectively
// if the element lies between low and high we will use binary search for the element if not we will set low pointer to high
// and high pointer to double of high and repeat the same process until we find the element.
int search(const ArrayReader& reader, int target) {
    int low = 0, high = 1;
    while(low<=high)
    {
        if(reader.get(low) <= target && target <= reader.get(high))
        {
            return binary_search(reader, target, low, high);
        }
        else if (target > reader.get(high))
        {
            low = high;
            high = 2 * high;
        }
        else 
        {
            return -1;
        }
    }
    return -1;
}
int binary_search(const ArrayReader& reader, int target,int low, int high)
{   
    int mid;
    while(low <= high)
    {
        mid = low + (high - low) / 2;
        if(reader.get(mid) == target)
            return mid;
        if(reader.get(low) <= target && target < reader.get(mid))
            high = mid - 1;
        else
            low = mid + 1;
    }
    return -1;
}