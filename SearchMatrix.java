/**
 * @author Vishal Puri
 * // Time Complexity : O(logn)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this : No
 */

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int r=matrix.length-1;

        while(l<=r){
            int m = l+(r-l)/2;
            if(matrix[m][0]==target)
                return true;
            else if(matrix[m][0] >= target){
                r=m-1;
            } else
                l=m+1;
        }

        int row = (r==-1)?0:r;
        l=0;
        r=matrix[row].length-1;
        System.out.println(row+" "+l+" "+r);
        while(l<=r){
            int m = l+(r-l)/2;
            if(matrix[row][m]==target){
                return true;
            } else if(matrix[row][m] >= target){
                r=m-1;
            } else
                l=m+1;
        }


        return false;
    }
}
