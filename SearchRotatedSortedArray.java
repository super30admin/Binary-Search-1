//Time Complexity: O(logn)
//Space Complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low+ (high-low)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            
            if(nums[low] <= nums[mid]){
                //if rotated array is left sorted
                if(nums[low] <= target && target < nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                //if rotated array is right sorted
                if(nums[mid] < target && target <= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}