/**
 * Time Complexity: Logarithmic
 * Space Complexity: Constant
 * LeetCode: Y  https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 * Approach: Given the array is sorted in ascending order, binary search algorithm can be used to find the target
 * To use the binary search to find target, it requires a definite range to apply binary search
 * To find the range: we start with high = 1 and multply the high by 2 until we find the target between the low and high bounds
 * Since high is doubled in each iteration, it would be done with logarithmic time complexity.
 * After knowing the bounds, apply binary search to find the exact target in logarithmic time complexity
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        // Initiate lower and upper bounds for the search space
        int low = 0, high = 1;
        
        // Double high until target is out of range
        while( reader.get(high) < target ) {
            high *= 2;
        }
        
        // Keep finding the target till a valid range to apply binary search exists
        while(low <= high) {
            // Get the middle
            int mid = low + (high - low) / 2;
            
            // If the middle element is the target
            if(reader.get(mid) == target) {
                return mid;
            }
            // If the target is in the right sub-array then discard the left sub-array 
            else if(reader.get(mid) < target) {
                low = mid + 1;
            }
            // If the target is in the left sub-array then discard the right sub-array 
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
