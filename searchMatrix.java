//Time Complexity: O(logn)
//Space Complexity: constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// we can make use of binary search to search for the target as the elements are in sorted order in the matix

class searchMatrix{
    public boolean searchMatrix(int[][] matrix, int target){
        // hi = number of elements in the matrix -1
        int lo = 0, hi = (matrix.length * matrix[0].length) - 1);
        int m = matrix[0].length;
        int mid;
        while(lo <= hi){
            mid = lo +(hi-lo)/2;
            int r = mid/m; // dividing the mid gives the row number;
            int c = mid%m; // percentile would give the column number
            if(matrix[r][c] == target) // if the element in the matrix is equal to target return true
                return true;
            if(target < matrix[r][c]) // if target is smaller we move hi to mid - 1 as the target is between lo and mid
                hi = mid -1;
            else
                lo = mid + 1; // else target is on other half of the array, hence we make lo to mid+1
        }
        return false; // return false if not found anywhere
    }
}
