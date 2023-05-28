// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No (Premium)
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
// as we dont know the length of the array we start with low at 0th index and high at 1st index.
// we want to find the range of low and high so we check the element at the high index is less than target if so increment high by 2 times 
// perform binary search.  
class solution {
    public int search(ArrayReader reader, int target){
        int low=0;
        int high =1;
        while(reader.get(high)<target)
        {
            low = high;
            high = 2*high;
        }
        while(low<=high)
        {
            int mid = low +(high-low)/2;
            if(reader.get(mid)== target) return mid;
            else if(reader.get(mid)> target) high = mid -1;
            else 
                low = mid-1;

        }
        return -1;
    }
}