class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while (low <= high) {
            int mid = (low + high)/2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] <= nums[mid]) { //if left array is sorted
                //if its sorted, check which half the target is in
                if (target <= nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if ((nums[mid] <= nums[high])) {//check same on right if its sorted
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}