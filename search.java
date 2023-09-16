/*Search in Rotated Sorted Array
  Time Complexity:- O(log n)
  Space Complexity:- O(1)*/
class Solution {
    public int search(int[] nums, int target) {
        //Base Case
        if(nums==null || nums.length==0){
            return -1;
        }
        int low=0;//set low=0
        int high=nums.length-1;//set high equal to length-1

        //looping until low<=high 
        while(low<=high){
            int mid=low+(high-low)/2; //prevent Integer Overflow
            if(nums[mid]==target){ //If target equal to mid 
                return mid; //return mid
            }
            if(nums[low]<=nums[mid]){ //If nums[low] is less than equal to nums[mid] 
                if(target>=nums[low] && target<nums[mid]){ //Check if target>=nums[low] && target<nums[mid]
                    high=mid-1; //Set high=mid-1
                }
                else{
                    low=mid+1; //Set low=mid+1
                }
            }
            else{
                if(target>nums[mid] && target<=nums[high]){ //Check if target>nums[mid] && target<=nums[high]
                    low=mid+1; //Set low=mid+1
                }
                else{
                    high=mid-1; //Set high=mid-1
                }
            }
        }
        return -1; //If the target is not found return -1
        
    }
}
