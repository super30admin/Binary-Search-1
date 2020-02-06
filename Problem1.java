// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : 162/196 cases passed on leetcode

// Your code here along with comments explaining your approach: Find the pivot which sees the division of exact rotation. Further, use binary search for the side where the number can be found. If pivot is greater than target search behind else search forward

class Solution {
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0;
        int pivot = 0;
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        while (i < nums.length - 1) {
            if (nums[i] > nums[i + 1]) {
                pivot = i;
                break;
            }
            i++;
        }
        if (nums[i] == target) {
            return i;
        }

        if (pivot == 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        if (nums[pivot] == target) {
            return pivot;
        } else if (nums[pivot] < target) {
            return binarySearch(nums, 0, pivot - 1, target);
        } else {
            return binarySearch(nums, pivot + 1, nums.length - 1, target);
        }

    }

    public int binarySearch(int arr[], int l, int r, int x) {

        if (r < l) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] == x) {
            return mid;
        }
        if (arr[mid] > x) {
            return binarySearch(arr, l, mid - 1, x);
        }
        if (arr[mid] < x) {
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
}