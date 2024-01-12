//Problem - Search in rotated sorted array
//Time Complexity - O(log n) n - number of elements in array
//Space Complexity - O(1) we are using constant amount of extra space 
//Code run successfully on Leetcode - Yes

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null)
        return -1;
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                 return mid;
            }

            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[high]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[high]){
                    high = mid + 1;
                }else{
                    low = mid - 1;
                }
            }
        }
    return -1;
    }
}
           
           