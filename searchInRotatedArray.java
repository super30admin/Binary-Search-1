public class searchInRotatedArray {

    /** Time Complexity : O(log n)
        Space Complexity : O(1)
        Did this code successfully run on Leetcode : Yes
        Any problem you faced while coding this : No


        Your code here along with comments explaining your approach in three sentences only **/

    public int search(int nums[], int target) {
        //Used Binary Search algorithm to find the index of the target
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
        //Returns the index if the target is located in the middle of the rotated array
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
        //If the target is in the range of left sorted part of the array:
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //If the target is in the range of right sorted part of the array
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
    //Returns -1 when the target is not present in the array
        return -1;

    }
}
