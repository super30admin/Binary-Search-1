
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. There are two possible sub arrays, both in ascending order.
 * 2. so we will compute mid and check if mid == target. If yes re return mid, else we go left or right
 * 3. We check if nums[mid] >= nums[low], which tells us that array is sorted from low to mid for sure.
 *    So we check if target lies in between low to mid. If yes, we continue search between low to mid - 1 or else we search from mid + 1 to high
 * 4. But if nums[mid] is not >= nums[low], then for sure we know that nums[mid] to nums[high] is sorted.
 *    So we check if target lies in mid to high. If yes we continue owr search from mid + 1 to high. Or else we search in mid - 1  to low. 
*/



class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
       
        while(low <= high){
            
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target)return mid;
            if(nums[mid] >= nums[low]){
                if(target >= nums[low] && target < nums[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }  
            }else{
               if(target > nums[mid] && target <= nums[high]){
                   low = mid + 1;
               }else{
                   high = mid - 1;
               }
            }          
            }
       
        return -1;
        } 
    }     


            
           