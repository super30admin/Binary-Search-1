// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class SolutionRotatedArray {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while(l<=r){
            int mid = l + (r-l)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[l]<=nums[mid]){
                if(target>=nums[l] && target<nums[mid]){
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            } else {
                if(target>nums[mid] && target<=nums[r]){
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}