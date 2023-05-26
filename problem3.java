
# Time Complexity : O(log(base 2)m + log(n))) where m = number of high pointers chosen and n = number of elements within the range
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


/*We find low and high, find the middle element of the section, run binary search through that section of the array*/

class Solution{
    public int search(ArrayReader reader, int target)
    {
        int low = 0;
        int high =1;
        while(reader.get(high)<target)
        {
            low = high;
            high = 2*high;
        }

        //range low to high
        while(low<high)
        {
            int mid = low + (high-low)/2; //beter than using (low + high)/2 [you will get integer overflow error]
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid)>target)
            {
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
            if(reader.get(high) == target) 
                return target;
            return -1;
        }

    }

};