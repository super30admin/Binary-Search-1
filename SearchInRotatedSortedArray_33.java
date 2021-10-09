// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        //Inti low and high for indexes
        int high = nums.length -1;
        int low=0;
        
        while(high >= low){
            // calculated mid
            int mid = low + ( high - low) / 2;
            
            if(nums[mid] == target){
                return mid;
            } 
            //Checking if left side of mid is sorted 
            else if(nums[mid]>=nums[low])
            {  // if target into sorted small array range will update low and high accordingly
                if(nums[low] <= target &&  nums[mid] > target){
                    high = mid -1;
                } else {
                    low = mid +1;
                    
                }
            } else {
            	// if target into sorted small array range will update low and high accordingly

                if(target > nums[mid] && target <= nums[high]){
                    low = mid+1;
                }else {
                    high = mid -1;
                }
            }
        }
        
        return -1;
    }
}