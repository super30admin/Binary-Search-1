// Time Complexity : O(logmn) where matrix is of size m*n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach:
/* consider the 2D array as 1d array
   Calculate the mid element index using the modulus and division on "number of columns" as we imagine to flatten it rowwise. then compare the value of the mid element with target and,
   move low and high pointers to the left or right side accordingly. ie perform standard binary search.
*/

class Search2d {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n -1;
        while(low <=high){
            int mid = low + (high - low)/2;
            int mid_elt = matrix[mid/n][mid%n];
            if (mid_elt == target) return true;
            else if (mid_elt > target){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return false;
    }
}