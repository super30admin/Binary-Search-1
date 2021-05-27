// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :


class Solution {
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length -1;

        while(left<=right) {
            int mid = left + (right-left) / 2;
            if(nums[mid] == target) return mid; /** if the middle element is the target */

            /**.the middle pivot element is more then the first element */
            else if(nums[mid] >= nums[left]) {

                if(target>=nums[left] && target<nums[mid]) right = mid - 1;
                else left = mid + 1;

            }
            else {

                if(target<=nums[right] && target>nums[mid]) left = mid + 1;
                else right = mid - 1;

            }



        }

        return -1;

    }
}