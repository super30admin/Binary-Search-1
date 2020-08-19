//Time complexity: O(logn)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class BinarySearchSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>=nums[left]){//rotation happened on the right side of the mid else on the left side
                if(target>=nums[left] && target<nums[mid])
                    right = mid-1;
                else
                    left = mid+1;
            } else{
                if(target<=nums[right] && target>nums[mid])
                    left = mid+1;
                else
                    right = mid-1;
            }
        }
        return -1;
    }
}