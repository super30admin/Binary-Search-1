//Time Complexity - O(log n)
//Space Complexity - O(1) Not using any extra space.

// Implemented using Binary search on rotated sorted array. After caluculating the mid I have compared
// value at mid with the value at low and high to find the sorted side of the array. If I find it on the
// left side I will then compare the target with value at low and mid and move the low and high values accordingly.
public class RotatedArray {
    public int search(int[] nums, int target) {
        if(nums == null && nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2; //prevent overflow
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }


        }
        return -1;

    }
}
