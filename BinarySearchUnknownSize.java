// Time Complexity : O(log n) where n is the number of elements in the array, but here we don't know what n is.
// Space Complexity :  Space complexity is the size of the array itself.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Approach :
// 1. Make use of two pointers. Slow pointer and fast pointer
// 2. Since we don't know the size of the array beforehand, we keep incrementing the fast pointer by 2 times. (ie f = f * 2)
// 3. As long as the fast pointer points to a value, whose value is less than the target, we keep updating the slow pointer to fast pointer and double the fast pointer.
// 4 When we find the range for our target, we do binary search.


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int slow = 0, fast = 1;
        if(reader.get(0) == target) return 0;
        if(reader.get(1) == target) return 1;
        //setting the boundaries
        while(reader.get(fast)<target) {
            slow = fast;
            fast *= 2; 
        }
        return binarySearch(reader, slow, fast, target);
    }    
        public int binarySearch(ArrayReader reader, int low, int high, int target) {
            //Binary Search
            while(low <= high) {
                int mid = low + (high-low)/2;
                int num = reader.get(mid);
                if(num == target) {
                    return mid;
                }
                else if(num < target) {
                        low = mid + 1;
                    }
                else
                    high = mid - 1;
            }
            return -1;
        }
        
    
}