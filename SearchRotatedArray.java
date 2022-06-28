class Solution {
    public int search(int[] nums, int target) {
        //binary search
        int low = 0;
        int high = nums.length -1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
           if(nums[ mid] == target){
               return mid;
           } else if(nums[mid] >= nums[low]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
               if(target <= nums[high] && target > nums[mid]){
                   low = mid + 1;
               } else {
                   high = mid - 1;
               }
           }
        }
        return -1;
    }
}
//time complexity: O(log(n))
//Space Complexity: O(1) 
// Did this code successfully run on Leetcode : Yes