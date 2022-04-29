class Solution {
   public int search(int[] nums, int target)
    {
        int result = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right)
        {
            if (nums[left] == target) return left; 
            else if (nums[right] == target) return right; 

            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;

            if (target > nums[mid] && target < nums[right]) left = mid+ 1; 
            else if (target < nums[mid] && target > nums[left]) right = mid - 1; 
            else
            {
                left++;
                right--;
            }
        }
        return result;
    }
}
