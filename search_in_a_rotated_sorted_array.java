// Time Complexity: O(log(N))
// Space Complexity: O(1)
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            
            // Target found
            if (target == nums[mid]) {
                return mid;
            }
            // If left half is non-rotated 
            else if (nums[mid] >= nums[left]) {
                // If 'target' in range, search in non-rotated array
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } 
                // Search in rotated right half
                else {
                    left = mid + 1;
                }
            } 
            // Right half is non-rotated
            else {
                // If 'target' in range, search in non-rotated array
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }
                // Search in rotated left half
                else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}