// Time Complexity : O(log n) as it's binary search.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not much, once the idea to find the sorted part on the array, it is a binary search to find the target.

// Your code here along with comments explaining your approach


class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while(low<=high){
            mid = low + (high-low)/2;  //to avoid number overflow
            if(nums[mid] == target){
                return mid;
            }
            if(nums[low] <= nums[mid]){ // considering the left half
                if(nums[low] <= target && nums[mid] > target){ //checking if target is in left half
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }else{ // considering the right half
                if(nums[mid] < target && nums[high] >= target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}