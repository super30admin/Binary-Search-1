// 702. Search in a Sorted Array of Unknown Size

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0; int high =1;
        while (reader.get(high) < Integer.MAX_VALUE 
               && reader.get(high) < target)
        {
            low = high ; 
            high = 2*high;
        }
        
        return binarySearch(reader, target, low, high) ;      
     }
    
    private int binarySearch(ArrayReader reader, int target, int low, int high)
    {
        while (low<=high)
        {
            int mid = low +(high-low)/2;
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) > target)
            {
                high = mid - 1;
            }else 
                low = mid + 1;
        }
        return -1;
    }
        
}


// Complexity Analysis

/*
Time complexity : O(logT), where T is an index of target value.
Space complexity : O(1) since it's a constant space solution.
*/
