// Time Complexity : O(long(n)) since we are reducing the search by half array each iteration.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Following normal 2 pointer algorithm for binary search but difference is added conditions to check if start to mid or mid to end is sorted or not,
// whichever is true, check the same binary search condirions there and update the start or end index.
class Solution {
    public int search(int[] nums, int target) {
        int startIndex =0,endIndex=nums.length-1;
        
        while(startIndex<=endIndex){
            
            int mid = (startIndex + endIndex)/2;
            if(nums[mid]==target)
                return mid;
            
            if(nums[startIndex] <= nums[mid]){
                if(nums[startIndex] <= target && nums[mid] > target){
                    endIndex = mid-1;
                }
                else{
                    startIndex = mid+1;
                }
            }
            if (nums[mid] <= nums[endIndex]) {
                if(target > nums[mid] && target <= nums[endIndex]){
                    startIndex = mid+1;
                }
                else{
                    endIndex =mid -1;
                }
            }
        }
           return -1;
        }
    }
