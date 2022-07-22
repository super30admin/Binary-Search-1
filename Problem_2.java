class Solution {
    /*
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (nums[mid] == target) 
                return mid;
            if (nums[low] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[low])
                    high = mid-1;
                else 
                    low = mid+1;
            }
            if (nums[mid] <= nums[high]) {
                if (target <= nums[high] && target > nums[mid])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
}