// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {

    public static boolean binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        // traverse for finding the target element
        while (l <= r) {
            // find the mid element
            int mid = (l + r) / 2;
            // if mid elemen is equal to our target element then we return true;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                // else if mid element is greater then target that means our target element may
                // be in first half of the array. So,
                r = mid - 1;
            } else {
                // else target element in second half of the array. So,
                l = mid + 1;
            }
        }

        // if array is not in our array we return false
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        // traverse through matrix
        for (int i = 0; i < matrix.length; i++) {

            // if our target element is greatar then or equal to first element in row and
            // less then or equal to last element in the row. we search in that row.
            if (target >= matrix[i][0] && target <= matrix[i][matrix[0].length - 1]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };

        int target = 3;
        System.out.println(target + " is available in matrix? " + searchMatrix(matrix, target));
    }
}