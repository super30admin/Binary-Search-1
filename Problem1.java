// Time Complexity : O(M+N) M would be the rows and N would be the columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach


public class Problem1 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length==0) return false;
        //low moves from row
        int low =0;
        //high moves for the columns
        int high = matrix[low].length -1;

        while(low <matrix.length && high>=0){

            if(matrix[low][high] == target)
            {
                return true;
            }
            else if(matrix[low][high] <target){
                low++;
            }
            else
            {
                high--;
            }
        }
        return false;


    }

}
