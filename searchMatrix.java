/*
 *  Time Complexity: O(log n) Since we are eliminating half of the matrix in each iteration.
 *  Space Complexity: O(1) Constant space.
 * 
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 * 
 *  Mark the low element as 0 and high element as product of rows and columns -1, once we have the outer bounds. Compute the mid element. Identify row and col of middle element by dividing it by number of columns and finding the modulus of middle index with number columns. The rest of the logic is same as binary search.
 */
class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0) return false;
        int left = 0, right=matrix.length*matrix[0].length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int row = mid/matrix[0].length;
            int col = mid/matrix[0].length;
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]<target) left = mid+1;
            else if(matrix[row][col]>target) right = mid-1;
        }
        return false;
    }
}