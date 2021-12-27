// Time Complexity : O(log n) where n is the number of elements in the array nums
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No Problems faced

class Problem2 {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length -1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            
            if(nums[lo]<= nums[mid]){
                if(nums[lo]<= target && target< nums[mid]){
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }
            }
            else{
                if(nums[mid]< target && target <= nums[hi]){
                    lo = mid +1;
                }
                else{
                    hi = mid -1;
                }
            }
        }
        return -1;
    }
}