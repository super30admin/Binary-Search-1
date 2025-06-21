// Time Complexity: O(log n)
// Space Complexity: O(1)

// First check if array is already sorted, if yes then apply binarySearch
// Second check if mid elem is target, if not check if either side is sorted and target might exist there and apply binary search

class Solution {
    public int search(int[] nums, int target) {

        int len = nums.length;


        // Check if array is already sorted a[0] <= a[n]
        if (nums[0] <= nums[len - 1]) {
            return binarySearch(nums, 0, len-1, target);
        }

        int low = 0, high = len - 1;
        while (low <= high) {

            int mid = low + (high-low) / 2;
            // Check if middle element is target
            if (nums[mid] == target) return mid;

            // if left side is sorted, and target might exist there, apply a binarySearch
            if(mid > 0 && nums[low] <= nums[mid-1]) {
                if (target <= nums[mid-1] && target >= nums[low]) {
                    high = mid - 1;
                    return binarySearch(nums, low, high, target);
                } else {
                    // but target exists in right side
                    low = mid + 1;
                }
            }

            // if right side is sorted, and target might exist there, apply a binarySearch
            if(mid + 1 < len && nums[mid + 1] <= nums[high]) {
                if (target <= nums[high] && target >= nums[mid + 1]) {
                    low = mid + 1;
                    return binarySearch(nums, low, high, target);
                } else {
                    // right side is sorted, but target exists in left side
                    high = mid - 1;
                }
            }

        }

        return -1;

    }


    public int binarySearch(int[] nums, int l, int r, int target) {

        while(l<=r) {

            int mid = l + (r-l)/2;

            if(target>nums[mid])
                l=mid+1;
            else if (target<nums[mid])
                r=mid-1;
            else
                return mid;

        }
        return -1;
    }
}