
/* Time Complexity :log(n)
 Space Complexity : O(1)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 
 Approach: Find out the wich part of the array is sorted and check target is the part of that
 half or another half and then do same binrary search

*/
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
        int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[low]<=nums[mid]){
                if(target >= nums[low] && target < nums[mid]){
                    high =mid-1;
                }else{
                    low = mid+1;
                }
            }
            else{
                if(target > nums[mid] && target <= nums[high]){
                   low = mid+1;
                }else{
                    high = mid-1;
                }
                
            }
        }
        return -1;    
    }
}
