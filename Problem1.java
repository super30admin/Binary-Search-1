// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Time Limit Exceeded
// Any problem you faced while coding this : How to get the pivot in LogN time


// Your code here along with comments explaining your approach


class Solution {
    public int search(int[] nums, int target) {
        
        int start = 0;
        
        int end = nums.length -1;
        
        int pivot = findPivot(nums, start, end);    
        
        // Target is less than pivot value, search the RHS

        if(pivot == 0 || target < nums[0]){
            return binarySearch(nums, pivot, end ,target); 
        }
        else{
            return binarySearch(nums, 0, pivot - 1 , target);
        }

}
    
public int findPivot(int[] nums, int start, int end){


    // Find the point at which the array is rotated
     
     int mid = start + (end-start)/2;
     
     while(end < start){
         
         if(nums[mid] > nums[mid-1]){
             return mid;
         }
         else if(nums[0] < nums[mid]){
             end = mid-1;
         }
        else{
            start = mid + 1;
        }
         
     }
    
  return 0;
     
 }
    

public int binarySearch(int[] nums, int start, int end, int target){


    // Normal binary search, after the pivot is found
    
    while(start <= end){
        
            int mid = start + (end - start)/2;
            
            if(target == nums[mid]){
                return mid;             
            }        
            
            else if(target < nums[mid]){
                start = mid - 1 ;
            }
            else {
                end = mid + 1;
            } 
    }
        
        return -1;

}
    
    
    
    
    
}
