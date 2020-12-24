// Time Complexity : O(m*n)   
// Space Complexity :O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach
class Search2DMatrix {

   


    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length==0) return false;    //checks if the array exists

        int rowLength=matrix.length;
        int columnLength=matrix[0].length;

        int[] targetRow= new int[columnLength];  // for the target array 
        
        for(int i=rowLength-1;i>=0;i--)
        {
            if( target >= matrix[i][0]) targetRow=matrix[i]; // selects the target array after comparing only the first elements of each row 
        }
        
        for(int j=0; j<=columnLength-1; j++)
        {
            if(target==targetRow[j]) return true;  // checks the target array for the value
        }
        return false;   // for the last case i.e target value does not exist
    }
    
}