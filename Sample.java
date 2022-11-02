// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//Q1

// Search a 2D martrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int noOfRows = matrix.length;
        int noOfCols = matrix[0].length;
        int low = 0;
        int high = (noOfRows * noOfCols) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // integer overflow
            int row = mid / noOfCols; // as each row has that many number of elements
            int col = mid % noOfCols; // because col is only between 0 and 3

            if (matrix[row][col] == target) {
                return true;
            }

            if (target > matrix[row][col]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return false;

    }
}

// Q2 - search in a rotated array

class Solution2 {
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("mid " + mid);

            if (nums[mid] == target) {
                return mid;
            }

            // first we search if we are in left sorted portion or right

            if (nums[left] <= nums[mid]) {
                // we are in left sorted portion
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // we are in right sorted portion

                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }

        }

        return -1;
    }
}

// Q3

class Solution3 {
    public int search(ArrayReader reader, int target) {

        if (reader.get(0) == target)
            return 0;

        int low = 0;
        int high = 1;

        // first we need to set the limit of low and high
        // so we start with 1 and keep moving forward

        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        // now we have are our low and high boundaries

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int num = reader.get(mid);

            if (num == target) {
                return mid;
            }
            if (num > target) {
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return -1;

    }
}