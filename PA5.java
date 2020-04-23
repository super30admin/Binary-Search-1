class Solution {
    public int search(int[] nums, int target) {
        if(nums.length ==0){
            return -1;
        }
        
        int i=0;
        int j= nums.length-1;
        
        int mid=0;
        while(i<=j){
            mid= (i+j)/2;
            
            if(nums[mid]== target){
                return mid;
            }
           if(nums[mid]>=nums[i]){
               if(target>=nums[i] && target<nums[mid]){
                   j= mid-1;
               }
               else{
                   i=mid+1;
               }
           }
            else{
                if(target>nums[mid] && target<=nums[j]){
                   i= mid+1;
               }
               else{
                   j=mid-1;
               }
            }
        
        }
        return -1;
    }
}