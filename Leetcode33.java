//Space Complexity - O(1)
// Time Complexity - O(log(n)) 
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1; 

        while (low < high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            if (nums[low] <= nums[mid]) {
                //left side is sorted
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid;
                } else {
                    low = mid+1;
                }
            } else {
                // right side is sorted
                if(nums[high] >= target && target > nums[mid]) {
                    low = mid +1;
                } else {
                    high = mid;
                }
            }
        }
        if (nums[low] == target) return low;
        
        return -1;
        
    }
}