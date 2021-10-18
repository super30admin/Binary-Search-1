/**
 * 
 * Leet code 702
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        // fast and slow pointers
        int slow = 0;
        int fast = 1;
        int mid;
        // Boundary Case 1
        if(reader.get(0) == target)
        {
               return 0;
        }
        // Boundary Case 2
        if(reader.get(1) == target)
        {
               return 1;
        }
        while(reader.get(fast) < target)
        {
            slow = fast;
            fast = fast*2;   
        }
        
        // Now slow is low and fast is high
        while(slow<=fast)
        {
            mid = slow+(fast-slow)/2;
            if(target == reader.get(mid))
            {
                return mid;
            }
            if(target > reader.get(mid))
            {
                slow = mid+1;    
            }
            if(target < reader.get(mid))
            {
                fast = mid-1;
            }
        }
        return -1;   
    }
}