/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

// Time Complexity - O(logn)
// Space Complexity - O(1)


// For Binary Search
// 1) Decrease the search space by half
// 2) Increase the search space by 2 times (Use this approach hear and increase the space by 2 times at each iteration and perform binary search)

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;

        while (reader.get(right) < target){
            left = right;
            right = right * 2; // Increase the search space by 2 times
        }

        while (left <= right)
        {
            int mid = left + (right - left)/2;
            if (reader.get(mid) == target){
                return mid;
            }
            else if (reader.get(mid) > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if (reader.get(left) == target){
            return left;
        }
        return -1;
    }
}