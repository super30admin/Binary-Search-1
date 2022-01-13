class Solution {
    public int search(int[] nums, int target) {
        int low =0;   
        int end = nums.length-1;
        
         while(low<= end){
             int mid= low+(end-low)/2;
              
             if(target == nums[mid])
                 return mid;
             
             else if(nums[low] <= nums[mid]){
                if(target < nums[mid] && target >= nums[low])
                    end=mid-1;
                
                 else low=mid+1;
            }
             else{
                 if(target> nums[mid] && target <= nums[end])
                    low=mid +1;
                else end =mid-1;
                } 
             }
           
           return -1;  
         }
 }
