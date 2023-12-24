// 74. Search a 2D Matrix

// Time Complexity : O(log mn) since we're doing binary search on all m*n elements
// Space Complexity : O(1) since we only used pointers 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// [1 3 5 7 10 11 16 20 23 30 34 60 68 72 74 76 81 85 89 92]
// [0 1 2 3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19]
//here 4 is matrix[0].length 
// 0/4 = 0, 0%4 = 0 -> remainder of 4/0
// 1/4 = 0, 1%4 = 1 -> remainder of 4/1
// 2/4 = 0, 2%4 = 2 
// 3/4 = 0, 3%4 = 3
// 4/4 = 1, 4%4 = 0
// 5/4 = 1, 5%4 = 1
// 6/4 = 1, 6%4 = 2
// 7/4 = 1, 
// 8/4 = 2
// .
// .
// .
// every row will have 4 elements
// dividing each element ka index by 4 will give row index
// mid%n will give col index
// mid/n will give row index

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        int low = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int high = (m*n)-1;
        while(low <= high){
            int mid = low+ (high-low)/2;
            int row = mid/n;
            int col = mid%n;
            if(target == matrix[row][col])
                return true;
            else if(matrix[row][col] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;
    }
}