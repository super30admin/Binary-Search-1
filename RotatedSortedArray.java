//TC: log(n)
//SC: o(1)

class Solution {
    public int search(int[] nums, int target) {
        int low =0 ;
        int hi = nums.length - 1;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(nums[mid]==target) return mid;
            if(nums[mid] >= nums[low]) { // left sorted array
                if(target >= nums[low] && target <= nums[mid]) {
                    hi = mid - 1;
                } else {
                    low = mid +1;
                }
            } else if ( nums[mid] <= nums[hi]) { // right sorted array
                if(target >= nums[mid] && target <= nums[hi]) {
                    low = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}