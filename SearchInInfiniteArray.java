// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Dont have leetcode premium
// Approach
// We will need to apply binary search to find the target element. Since we dont know the end. Take first index as low
// and second index as high, if the target index is not between these values, increase the high index and make it twice the current index.
// If the element is smaller than the current high index, apply binary search on the current low and high indices.
public class SearchInInfiniteArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int low = 0;
        int high = low + 1;
        while (target > nums[high]) {
            low = high;
            high = high * 2;
        }
        return binarySearch(nums, target, low, high);
    }

    public int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
