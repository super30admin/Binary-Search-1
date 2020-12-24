// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, was not sure how binary search could work on a non-sorted array since the sorted array gets rotated/
//However, since we know that rotated means one side is always sorted, we can break down the array into an interval where everything is sorted.


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        //first find which side is sorted
        //then check if the sorted side contains the target
        //if not, search the unsorted side. 
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = (low+high) / 2;
            if(nums[mid] == target) return mid;
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && nums[mid] > target){
                    high = mid-1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(nums[mid] < target && nums[high] >= target){
                    low = mid+1;
                }else{
                    high = mid -1;
                }
            }
            
        }
        return -1;
        
    }

}