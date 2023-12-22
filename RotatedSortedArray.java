/*
* Approach:
*  1. Apply Binary Search because atleast once side will be sorted
* 
*  2. Find mid and check which part is sorted 
        by comparing low and mid
* 
*  3. Check if target lies in sorted part or not, 
        based on that update low and high
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(logN)
* 
* Space Complexity: O(1)
    Recursive approach of binary search: O(logN) -> stack space
* 
*/
public class RotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] == target)
                return mid;

            else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid])
                    high = mid - 1;

                else
                    low = mid + 1;
            }

            else {
                if (nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }
}
