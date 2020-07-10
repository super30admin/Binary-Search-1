/* Time complexity : O(logn)
Space complexity : O(n)

1. We successively increase the search space (double) in this binary search to find the target
2. Time complexity remains the same as that of regular binary search.
3. After a desired search window is obtained in which the element lies, we can carry out binary search to find its index. */


class Solution{
    public int search(ArrayReader reader, int target){
        int low, high = 0, 1;
        while(reader.get(high) > target){
            low = high;
            high = 2*high;
        }
        return binarySearch(reader, target, low, high);        
    }

    public int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid) > target){
                high = mid - 1;                
            }
            else{
                low = mid + 1;
            }

        }
        return -1;        
        
    }
}