// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none
/**
 * Brute Force: Linear Search => TC: O(m * n), SC: O(1)
 * 
 * Better 1: For each row, check the range, if valid for target => apply Linear
 * Search on that row
 * TC: O(m + n), SC: O(1)
 * 
 * Better 2: For each row, check the range, if valid for target => apply Binary
 * Search on that row
 * TC: O(m + log n), SC: O(1)
 * 
 * Optimal 1: Since Columns are sorted, Apply Binary Search on 0-th Column
 * For each mid row, check the range, if valid for target => apply Binary Search
 * on that mid row
 * TC: O(log m + log n), SC: O(1)
 * 
 * Optimal 2: since every 1st elemnt of a row < last element of the previous row
 * => it means if we flatten the 2D matrix it will be a sorted 1D matrix
 * Flatten the 2D matrix to 1D matrix, apply Binary Search
 * TC: O(log(m * n) == O(log m + log n), SC: O(1)
 */
public class SearchSortedMatrix {
    public SearchSortedMatrix() {

    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = 0;
        int hi = m - 1;
        int row = 0;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][n - 1]) {
                row = mid;
                break;
            }
            if (matrix[mid][0] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        lo = 0;
        hi = n - 1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = 0;
        int hi = m * n - 1;
        int mid, r, c;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            r = mid / n;
            c = mid % n;
            if (matrix[r][c] == target) {
                return true;
            }
            if (matrix[r][c] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}