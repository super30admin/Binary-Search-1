// Time Complexity :
//--o(1)
// Space Complexity :
//--O(1)
// Did this code successfully run on Leetcode :
//--yes
// Any problem you faced while coding this :
//--no issue


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;}
        int low = 0;
        int high = nums.length - 1 ;
        //Check if pointer low is less than high
        while(low<=high) {
            int mid = low + (high - low)/2; // prevent integer overflow
            //checking if mid equals target
            if (nums[mid]==target){
                return mid;
            }
            //checking if left side is sorted
            if(nums[low]<= nums[mid]){
                if(target>=nums[low] && target<=nums[mid]) {
                high = mid -1;

            }
            //if not sorted
                else{
                low = mid + 1;
            }
            }

            else{
                //checking if right side is sorted
                if(target>=nums[mid] && target<=nums[high]){
                    low = mid + 1;
                
                }
                //if not
                else{
                    high = mid - 1;
                }
            
            }
           
            

        }

    return -1;
    }
}