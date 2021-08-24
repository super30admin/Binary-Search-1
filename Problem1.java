// Time Complexity : log(n) where n is the size of an array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target) return mid;
            else if(nums[low] < nums[mid]){
                if(nums[low]<=target && (mid==0 || target<=nums[mid-1])){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }   
            else{
                if(nums[high]>=target && ((mid==nums.length-1) || target>=nums[mid+1])){
                    low = mid+1;
                    
                }
                else{
                    high = mid-1;
                }
            }
        }
        
        return -1;
    }
}
