/**
 * Time Complexity : O(max(m,n))
 *  Space Complexity : O(1)
 * Did this code successfully run on Leetcode : YEs
 * Any problem you faced while coding this : Confused with why we take row as mid / m and col as mid % m
 * Explanation: We consider the 2d array as a 1D array and find the mid from start and end. Then, We find
 * out the row and col index with mid and that is our mid in the 2D array. We check with regular binary 
 * method i.e., if target > the mid at that row and col then we incr start = mid+1 else end = mid-1
 */

class TwoDMatrix {
    
        public static void main(String args[]) {
            int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
            int target= 3;
            TwoDMatrix obj = new TwoDMatrix();
            boolean ans = obj.searchMatrix(matrix, target);
            System.out.println(ans);
        }
        public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        //assuming the 2d matrix to be a 1dmatrix method
       int n = matrix.length; //length of matric
       int m = matrix[0].length; //col length
       int start = 0, end = (m*n)-1;

       while(start <= end){
           int mid = start + (end - start)/2;
           //we do this to find the pos of mid in the 2d array
            int row = mid / m; 
            int col = mid % m;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target){
                start = mid +1;
            } else {
                end = mid - 1;
            }

       }
    return false;
    }
}
