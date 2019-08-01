
//ran this on leetcode

public class Solution {
    public int search(int[] nums, int target) {
        int start_index = 0;
        int end_index = nums.length - 1;
        while (start_index <= end_index){
            int mid = (start_index + end_index) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start_index] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start_index])
                    end_index = mid - 1;
                else
                    start_index = mid + 1;
            }

            if (nums[mid] <= nums[end_index]){
                if (target > nums[mid] && target <= nums[end_index])
                    start_index = mid + 1;
                else
                    end_index = mid - 1;
            }
        }
        return -1;
    }
}


