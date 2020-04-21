//Time Complexity : O(logn)
//Space Complexity : O(1)

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left+right)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[left] <= nums[mid]){
                if(target < nums[mid] && target >=nums[left]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else if(nums[right] >= nums[mid]){
                if(target > nums[mid] && target <=nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
           
        }
        return -1;
        
    }
}