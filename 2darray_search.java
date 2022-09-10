// Time Complexity : 0(log n)
// Space Complexity :
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
class Solution {
    public int search(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) return -1;
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <=high){
            
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }
            //left part is sorted
            if(nums[low] <= nums[mid]){
                if(target < nums[mid] && target >= nums[low]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            //right is sorted
            else{
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid -1;
                }
                
            }
        }
        return -1;
    }
}
