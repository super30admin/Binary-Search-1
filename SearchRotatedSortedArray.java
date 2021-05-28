/**
 * @author Vishal Puri
 * // Time Complexity : O(logn)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this : No
 */

class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null && nums.length == 0) return -1;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid= left + (right - left)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[left]<=nums[mid]){
                if(nums[left]<=target && nums[mid]>target){
                    right=mid-1;
                } else{
                    left=mid+1;
                }
            } else{
                if(nums[mid]<target && nums[right]>=target){
                    left=mid+1;
                } else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}