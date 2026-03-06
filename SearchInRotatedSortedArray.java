// TimeComplexity: O(logn)
// SpaceComplexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) return mid;
            if(nums[low]<= nums[mid]) {
                // left sorted
                if(nums[low] <= target && target < nums[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                // right sorted
                if(nums[mid] < target && target<= nums[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } 
        }
        return -1;
    }
}
