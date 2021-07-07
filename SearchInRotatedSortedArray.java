//Time - O(logN)
//Space - O(1)
//Invalid case -> [7,6,4,3,2,1]
//Definetly one half sorted in increasing order
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0; int high = nums.length-1;
        while(low<=high){       
            int mid = low + (high-low)/2;    
            if(nums[mid] == target) return mid;
            else if(nums[low] <= nums[mid]){                   //check if left sort
               if(nums[low] <= target && nums[mid] > target){  //check if present in this left sort
                   high = mid-1;
               }
               else{
                   low = mid+1;
               }
            }
            else{                                            //right sort
               if(nums[mid] < target && nums[high] >= target){ //check if present in this right sort
                   low = mid+1;
               }
               else{
                   high = mid-1;
               }
            }
        }
        return -1;
    }
}