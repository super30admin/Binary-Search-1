/**
 * Set the boundary initially to [0, 1]. while (right element < target) then 
   make left = right && shift and extend the *rightIndex to 2 places to right side 
   by right = right *2; 
 * This happens until right element > target. If (rightElement > target) comes out of the loop;
 * Implement the normal binary search algorithm after that;
 * Time complexity is O(1);
 * Space complexity O(1);
 * Ran and accepted in leetcode succesfully.
 */

class InfiniteSortedArray {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        
        while(reader.get(right) < target) {
            left = right;
            right = right * 2;
        }
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            if(reader.get(mid) == target) {
                return mid;
            }
            
            if(reader.get(mid) < target) {
                left = mid + 1;
            } else if (reader.get(mid) > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}