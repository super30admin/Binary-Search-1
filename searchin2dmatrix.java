// Time Complexity: First for loop traverses each row and checks its first and last index value, in worst case if element is close to last element in matrix it would take m row traversal, inside that we perform binary search as numbers are sorted which takes log(n) time
// therefore worst time complexity comes out to be O(mlog(n)) where m are number of rows and n are number of columns
// Space Complexity: As matrix is already given and we have only used couple of variables only, this is an O(1) space

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : forgot to write return on binarySearch Recursion causing  a wrong output as even with true there was no value being returned

// Your code here along with comments explaining your approach
class Solution {
    // the idea is to limit number of traversals
    // as per conditions given, every row's 0th element is greater than prev row's last element, and each row is sorted in increasing manner
    // we are able to deduce if only first and last elements are compared with target
    // we do not need to traverse all elements in each row
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // in case target is at first or last position of matrix we do not need to perform linear searches
        if(target< matrix[0][0] || target> matrix[m-1][n-1]) {
            return false;
        }
        for(int i = 0; i<m; i++) {
            if(target==matrix[i][n-1]) {
                return true;
            }
            if(target>=matrix[i][0] && target<matrix[i][n-1]) {
                return binarySearch(target, matrix[i], 0, n);
            }
        }
        return false;
    }
    
    // as each row is sorted binary search is not efficient as we discard half array every time to achieve log(n) search time complexity.
    public boolean binarySearch(int target, int[] row, int low, int high) {
        if(high>=low) {
            int mid = low + (high-low)/2;
            if(target==row[mid]) {
                return true;
            } else if(target<row[mid]) {
                return binarySearch(target, row, low, mid-1);
            } else {
                return binarySearch(target, row, mid+1, high);
            }
        }
        return false;
    }
}