Question 2) Search in a Rotated Sorted array.
class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<nums[end]){
                if(nums[mid]<=target && target<=nums[end]){
                    start=mid+1;
                }
                else{
                    end=mid;
                }
            }
            else{
                 if(nums[start]<=target && target<=nums[mid]){
                    end=mid-1;
                }
                else{
                  start=mid+1;
                }
                
            }
            
           
        }
      return -1;  
    }
}
