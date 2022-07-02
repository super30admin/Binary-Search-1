// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no



public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        
        if(nums==null || nums.length==0) return -1;
        
        int low =0;
        int high = nums.length-1;
        while(low<=high){
           int mid = low +(high- low)/2;
            //check if mid is target
            if(nums[mid]== target)
                return mid;
            //check which part is sorted
            if(nums[low]<=nums[mid]){
                //left part is sorted
                if(target>=nums[low] && target<nums[mid]) {
                    //traget lies in sorted part
                    high = mid-1;
                }                    
                else{
                    low = mid+1;
                }                
            }else{
                 //left part is sorted
                if(target > nums[mid] && target <= nums[high]){
                     //traget lies in sorted part
                    low = mid +1;                    
                }else {                    
                  high = mid -1;  
                }             
            }
            
        }              
        
        return -1;      
        
    }
}
