// Time Complexity
// With bruteforce solution: O(n)
// With Binary search Optimization: O(Log n)
// Where n = number of elements in array.
// Space Complexity
// With bruteforce solution: O(1)
// With Binary search Optimization: O(1)

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1; // Check for the empty array scenario
        int low = 0; // first index of array
        int high = nums.length - 1; // last index of array
        while (low <= high) { // Loop until low becomes greater than high
            int mid = low + (high - low) / 2; // Mid point of the array
            if (nums[mid] == target)
                return mid; // Check if the mid is our target, if yes return true
            else if (nums[low] <= nums[mid]) { // this tells if left side is sorted
                if (nums[low] <= target && nums[mid] >= target) { // Check if the target is between low and mid index
                    high = mid - 1; // if yes move high before mid
                } else {
                    low = mid + 1; // if yes move low after mid
                }
            } else { // right sorted
                if (nums[mid] < target && nums[high] >= target) { // Check if the target is between mid and high index
                    low = mid + 1; // if yes move low after mid
                } else {
                    high = mid - 1; // if yes move high before mid
                }
            }
        }
        return -1;
    }
}