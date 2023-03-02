/*
Time Complexity - O(Log N) where N is the size of the array. 
Space Complexity - O(1).
*/

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */



class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) 
            return 0;
        int left = 0, right = 1;
        
        // until right boundary's value is lesser than target 
        // set left to cur right and keep pushing the right boundary 2 fold.
        while (reader.get(right) < target) {
          left = right;
          right *= 2;
        }
        

        // binary search
        int pivot, num;
        while (left <= right) {
          pivot = left + ((right - left) / 2);
          num = reader.get(pivot);

          if (num == target) return pivot;
          if (num > target) right = pivot - 1;
          else left = pivot + 1;
        }

        return -1;
    }
}
