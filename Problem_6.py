class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) 
                return mid;

            if (nums[left] <= nums[mid]) {// Left part
                if (target >= nums[left] && target < nums[mid]) 
                    right = mid - 1;
                else
                    left = mid + 1;
            }

            if (nums[mid] <= nums[right]) {// Right part
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }		
        return -1;
    }
}