//PROBLEM - Search in a Rotated Sorted Array 
/** 3 Pointer Approcach: 
 * Fact utilized : If we can get half items to compute at each progressive iterarion  
 * the problem can be resolved in Log N time.
 * Here we have rotated array, however at any given iteration we will always have 
 * half array sorted - either left or rigth.
 * This Symmetric Iteration is utlized tosearch item index.
 */ 
//
//time Complexity :
// Search - LOG(N)

// Space Complexity :
// O(1)

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO


class Problem1 {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        
        //till start dont cross end
        while(start <= end){
            
            int mid = start + (end-start)/2;
            
            if(nums[mid] == target) //number found
            return mid;
            
            if(nums[start] <= nums[mid]){ // left sorted 
                
                if(nums[start] <= target && target < nums[mid]){
                    end = mid - 1;
                }else{
                   start = mid+1;
                }
                
            }else{     // right sorted
                
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                }else{
                   end = mid-1;
                }
            }
        }
        
        return -1;
    }
    
}