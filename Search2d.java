// Time Complexity : O(logmn) Since we're using binary search
// Space Complexity : O(1) we are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

/*
* BruteForce approach - Search whole matrix using two for loops - O(mn)
* Approach 2 - Apply binary search on columns / rows - O(m*(logn)) or O(n*(logm))
* Optimized approach - This function performs a binary search on a 2D matrix represented as a 1D array.
* It calculates the indices for the mid-element using the division and modulo operations based on the row and column dimensions.
* Then, it updates the search range by comparing the target with the mid-element and adjusting the left and right pointers accordingly
*  until the target is found or the search range is exhausted, returning true if the target is found and false otherwise.
* */

public class Search2d {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid_index = left + (right - left) / 1;
            int mid_ele = matrix[mid_index/n][mid_index%n];
            if (mid_ele == target) return true;
            else if(mid_ele > target) {
                right = mid_index - 1;
            } else {
                left = mid_ele + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(searchMatrix(matrix, 100));
        System.out.println(searchMatrix(matrix, 10));
    }
}

