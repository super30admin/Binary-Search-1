/*
 * Time Complexity : O(log(mn))
 * Space Complexity :  O(1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - We treat this 2-D matrix as a sorted 1-D array and perform binary search on it. We find the mid point, low and high for the 1-D array and then perform the 
 * comparisons on the 2-D matrix elements by converting the 1-D array index to its corresponding 2-D array row and column index value. To get the row index, we take the 
 * 1-D array index and divide it by no: of columns. Similarly we get the column index, we take the 1-D array index and take modulo of it by no: of columns.
 */


//https://leetcode.com/problems/search-a-2d-matrix/submissions/886263488/
class BS_2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix ==null) return false;
        int n=matrix.length;
        int m=matrix[0].length;
        int low=0;
        int high=m*n -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(matrix[mid/m][mid%m] == target) return true;
            else if(target<matrix[mid/m][mid%m] && target>=matrix[low/m][low%m]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }

}