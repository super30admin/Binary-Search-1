// Time Complexity :O(logn)->n-number of elements in array
// Space Complexity :O(1)
/* Approach:
Binary search on the rotated sorted array by checking which half (left or right) is sorted at each step.
If the left half is sorted(check if low is less than or equals to mid), check if the target lies within its bounds — if so, search left, otherwise search right.
If the right half is sorted, check if the target lies within its bounds — if so, search right, otherwise search left.*/
class Solution {
    public int search(int[] nums, int target) {
        // empty array case
        if (nums == null || nums.length == 0) {
            return -1;// No elements in the array, so nothing to search and return.
        }
        int n = nums.length;// length of array
        int low = 0;// lower bound
        int high = n - 1;// upper bound
        // binary search loop
        while (low <= high) {
            int mid = low + (high - low) / 2;// Mid index calculation & used this the formula for preventing Integer
                                             // overflow
            if (nums[mid] == target) {// if mid index element equals target return mid index.
                return mid;
            }
            if (nums[low] <= nums[mid]) {// check if element at lower bound is less than or equals to element at mid, if
                                         // it passes this case, it mean left side is sorted
                if (target >= nums[low] && target < nums[mid]) {// checking if target lies between lower bound and mid
                    high = mid - 1;// if it lies narrowing search to left half
                } else {
                    low = mid + 1;// if it doesnt lie narrowing search to right half
                }
            } else {// else right half must be sorted
                if (target > nums[mid] && target <= nums[high]) {//// If target is within the sorted right half
                    low = mid + 1;// Narrowing search to right half
                } else {
                    high = mid - 1;// Narrowing search to left half
                }
            }
        }
        return -1; // Target was not found in array
    }
}