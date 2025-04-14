// Time Complexity : O(logn) // since we are doing binary search
// Space Complexity : O(1) //since we are not using any extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public int search(int[] nums, int target) {
        //first check if my mid is equal to the target
        /* if not check if the value b/w low and mid are sorted , if its sorted then check if target lies in that range*/
        //base case
       if(nums == null || nums.length == 0) return -1;
       int n = nums.length;
        int low = 0;
        int high = n -1 ;
         
        while(low<=high){
          int  mid = low+(high - low)/2; //avoid integer overflow
          if(target == nums[mid]){
              return mid;
          }
          //check which part is sorted
       else if(nums[low] <= nums[mid]){//left part is sorted
       //check if target lies in the left part
            if(target >= nums[low] && target < nums[mid]){
                //move left
                high = mid -1;
            }
            else{
                //move right
                low = mid+1;
            }
        }
        else{
            //right part of array is sorted
            //check the target lies in right half
            if(target >= nums[mid] && target <= nums[high]){
                low = mid+1;
            }
            else{
                high = mid -1;
            }       
        }

        
    }
     return -1;
}
}