//Solution in O(logN) -> First option that comes to mind is Binary Search
//Overall Time Complexity: O(logN)
//Overall Space Complexity: O(1)
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) return mid;

            if(nums[mid] >= nums[left]){ //Left Sorted
                if(target >= nums[left] && target < nums[mid]){
                    right = mid -1;
                }else{
                    left = mid + 1;
                }
            }else{ //Right Sorted
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

        }

        return -1;
    }
}