// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int midRow = 0;

        //Finding row 
        while(start <= end){
            midRow =  start + ((end - start) /2);
            if(matrix[midRow][0] == target)
                return true;
            else if(matrix[midRow][0] > target){
                end = midRow - 1;
            }
            else{
                if(matrix[midRow][matrix[midRow].length -1 ] < target)
                    start = midRow + 1;
                else
                    break;
                
            }
        }

        //Iterating that particular row
        for(int j = 0; j < matrix[midRow].length; j++){
            if(matrix[midRow][j] == target)
                        return true;
        }
        return false;
    }
}