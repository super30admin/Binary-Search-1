/**
 * The idea is to use normal binary search once arr[low ... high] is
 * monotonically increasing. The task of modifiedBinarySearch is to eliminate
 * search and figure out if the target lies in sorted region. Space Complexity:
 * O(1) Time Complexity: O(log n)
 */
class SearchRotatedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return modifiedBinarySearch(nums, 0, nums.length - 1, target);
    }

    /**
     * If arr[low...high] is monotonically increasing, call binarySearch on it. If
     * not compute mid and check if it matched target. Then start eliminating search
     * space by half and determine whether or not target lies in the sorted half or
     * not.
     */
    private int modifiedBinarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            if (arr[low] < arr[high]) { // in the montonically increasing region
                return binarySearch(arr, low, high, target);
            }
            int mid = low + (high - low) / 2;
            if (target == arr[mid]) { // lucky case?
                return mid;
            }
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < arr[mid]) {
                high = mid - 1;
            } else if (target == arr[mid]) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}