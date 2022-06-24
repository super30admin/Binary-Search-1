//Amazon Interview question
//Time complexity = O(logn)
//Space complexity = O(1)
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length ==0) return -1;
        int n=nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid=low+(high-low)/2;//To avoid integer overflow
            if(nums[mid]==target){
                return mid;
            }
            //Now check which part is sorted in array 
            //Left part is sorted array
            else if(nums[low]<=nums[mid]){
                //check if target lies in the left part
                if(target>=nums[low] && target<nums[mid]){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }else{
                //check right part is sorted
                if(target>nums[mid] && target<=nums[high]){
                    low = mid+1;
                } else{
                    high = mid-1;
                }
            }
        }
        return -1;
        
    }
}