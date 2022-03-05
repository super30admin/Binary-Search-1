// Time Complexity : O(n) ; where n is max(rows,cols)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {	
	/**Time O(n)| O(1) ; where k is max(rows,cols)**/
	public boolean searchMatrix(int[][] matrix, int target) {
        int row=0;      
        //Find row where the element can exist
        for(int i=0; i<matrix.length; i++){
            if(target <= matrix[i][matrix[0].length-1]) {
            	row=i;
            	break;
            }
        }     
        //Find element in row
        for(int j=0; j<matrix[0].length; j++){
            if(matrix[row][j]==target){
                return true;
            }
        }        
        return false;
    }
}