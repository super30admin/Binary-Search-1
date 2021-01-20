// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int l = 0;
        int r = m * n - 1;
        int mid;
        while (l <= r) {
            mid = (l + r)/2;
            int midElem = matrix[mid/n][mid%n];         //we will using / and % to traverse the matrix across rows
            if (midElem == target)
                return true;
            else if (target < midElem)
                r = mid - 1;
            else  l = mid + 1;
        }
        return false;
    }
}

/**************** Another implementation ****************/

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1])
//             return false;
//         int i = 0;
//         for (i = 0; i < matrix.length - 1; i++)
//             if (target >= matrix[i][0] && target < matrix[i + 1][0])
//                 break;
//         int low = 0;
//         int high = matrix[0].length - 1;
//         while (low <= high) {
//             int mid = (low + high)/2;
//             if (matrix[i][mid] == target)
//                 return true;
//             else if (target < matrix[i][mid])
//                 high = mid - 1;
//             else low = mid + 1;
//         }
//         return false;
//     }
// }


















