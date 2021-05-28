//Time Complexity: O(LogN)
//Space Complexity: O(1)
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
//Memory Usage: 38.7 MB, less than 8.42% of Java online submissions for Search in Rotated Sorted Array.
 // No issues
  
class Solution {
    public int search(int[] nums, int target) {
        
    int left = 0;
    int right = nums.length - 1;
            
        
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }else if(nums[mid] > target){
            if(nums[mid] >= nums[left] && nums[left] > target){
                left = mid + 1;
            }else{
                right = mid-1;
            }
        }else{
            if(nums[mid] <= nums[right] && nums[right] < target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }        
        }
    }
    return -1;  
    }
}

