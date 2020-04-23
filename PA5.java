class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] res= {-1,-1};      
        int low= 0;
        int high = nums.length-1;
        int mid= 0;
        int index=-1;
        while(low<=high){
            mid= low+(high-low)/2;
            if(nums[mid]==target){
                if(mid<nums.length-1 && nums[mid+1]== target){
                    low= mid+1;                   
                }
                else{
                   
                    res[1]= mid;
                    break;
                }
            }
            else{
                  if(nums[mid]>target){
                high= mid-1;
            }
            else{
                low= mid+1;
            }
            }       
        }
        low= 0;
        high= res[1];
        mid=0;
         while(low<=high){
            mid= low+(high-low)/2;
            if(nums[mid]==target){

                if(mid>0 && nums[mid-1]== target){
 
                    high= mid-1;
                    
                }
                else{
   
                    res[0]= mid;
                    break;
                }
            }
             else{
                 if(nums[mid]>target){
                high= mid-1;
            }
            else{
                low= mid+1;
            }
             }
            
            
        }
        return res;    
    }
}