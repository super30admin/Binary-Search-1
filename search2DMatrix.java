// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
1. Perform binary search on the outer array by checking the last and first values of each array element
2. At each array check if the target element is within the range of the current array by comparing the first and last element.
3. Pass the inner array to a function to perform normal binary search
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return performBinarySearchOnBigArray(matrix, 0, m-1, m ,n, target);
    }
    
    public boolean performBinarySearchOnBigArray(int[][] matrix, int l, int r, int m, int n, int target) {
        int mid = l + (r - l) /2;
        if(r>= l) {
            if(target >= matrix[mid][0] && target<= matrix[mid][n-1]) {
                return binarySearchOnSmallArray(matrix[mid], 0, matrix[mid].length - 1, target);
            }
            else if(matrix[mid][0]> target) {
                return performBinarySearchOnBigArray(matrix, l, mid-1, m, n, target);

            }
            return performBinarySearchOnBigArray(matrix, mid+1, r, m, n, target);
        } 
        return false;
            
    }
    
    public boolean binarySearchOnSmallArray(int[] arr, int l, int r, int target) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target)
                return true;

            if (arr[mid] > target)
                return binarySearchOnSmallArray(arr, l, mid - 1, target);
 
            return binarySearchOnSmallArray(arr, mid + 1, r, target);
        }
 
        return false;
        
    }
}