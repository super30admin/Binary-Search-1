/*

Time Complexity :  log(n)  // everytime we divide array by half so time is log(n).
Space Complexity : O(1) // We are not using any auxillary space.

*/

class Solution_RotateArray {
    public int search(int[] nums, int target) {

        // base condition
        if (nums.length == 0)
            return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            // taking the middle element index of the array
            // and also checking integer overflow condition if data will be big it also work
            // with this formula.

            int mid = left + (right - left) / 2;

            // if found returning the index.
            if (nums[mid] == target) {

                return mid;
            }
            // as per the question we definetly get one sorted part so we have to find that
            // and do searching.

            else if (nums[left] <= nums[mid]) {

                // checking if target is in this range or not
                if (nums[left] <= target && nums[mid] > target) {

                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            else {

                if (nums[right] >= target && nums[mid] < target) {

                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return -1;

    }
}