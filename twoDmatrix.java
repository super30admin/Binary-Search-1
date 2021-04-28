package Default;
//Time Complexity :
//Space Complexity :
//Did this code successfully run on Leetcode :
//Any problem you faced while coding this :


//Your code here along with comments explaining your approach
public class twoDmatrix {
public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length == 0){ // Check for null case
            
            return false;
        }
        
        int r = matrix.length; //Find length of row and column
        int c = matrix[0].length;
        int l = 0;
        int h = r * c - 1; 
        
       // System.out.println(r +"row is "+ c);
        
        while(l <= h ){
            
            int mid =  l + (h - l)/2;
            int m = mid / c; //Calculate row and column for middle element in 2D array
            int n = mid % c;
            
            if(matrix[m][n] == target){
                
                return true;
            }
            
            else if(matrix[m][n] < target){
                
                l = mid + 1;
            }
            
            else h = mid - 1;
            
        }
        
        return false;
        
    }

}
