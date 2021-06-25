// Time Complexity : o(logn)
// Space Complexity : constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        int mid;

        while(left<=right){

            mid = (left+right)/2;

            if(nums[mid] == target) return mid;

            else if(nums[mid] <= nums[right]){

                if(target > nums[mid] && target<= nums[right]){

                    left = mid + 1;
                }
                else{

                    right = mid -1 ;
                }

            }

            else if(nums[mid] >= nums[left]){

                if(target <= nums[mid] && target >=nums[left]){

                    right = mid - 1;
                }
                else{

                    left = mid + 1;
                }

            }

        }

        return -1;

    }
}
