class Solution {
    public int search(int[] nums, int target) {
        int startIndex =0,endIndex=nums.length-1;
        
        while(startIndex<=endIndex){
            
            int mid = (startIndex + endIndex)/2;
            if(nums[mid]==target)
                return mid;
            
            if(nums[startIndex] <= nums[mid]){
                if(nums[startIndex] <= target && nums[mid] > target){
                    endIndex = mid-1;
                }
                else{
                    startIndex = mid+1;
                }
            }
            if (nums[mid] <= nums[endIndex]) {
                if(target > nums[mid] && target <= nums[endIndex]){
                    startIndex = mid+1;
                }
                else{
                    endIndex =mid -1;
                }
            }
        }
           return -1;
        }
    }
