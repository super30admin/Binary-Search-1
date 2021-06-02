// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : had to revisit lecture to remember the condition to find the sorted side

class Solution {
    public int search(int[] nums, int target) {
        if(nums ==  null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        System.out.println(high);
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }else if (nums[low] <= nums[mid]){ //left part is sorted
                if(nums[low] <= target && nums[mid] > target){
                    high = mid - 1;
                } else{
                    low = mid + 1;
                }
            }else{
                if(nums[mid] < target && nums[high] >= target){
                    low = mid + 1;
                } else{
                    high = mid - 1;
                }
            }
        }
        
        return -1;
    }
}
