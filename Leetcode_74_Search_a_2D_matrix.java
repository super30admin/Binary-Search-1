/*
approach -1
flatten the array
search for it, if couldn't find, return false
tc: (m*n)
sc: O(m*n)*/

/*
approach-2
build a set, add elements there, look for target
if ot found, false, else true.
tc & SC O(m*n)*/

/*
binary search approach
start from the corners, top right, bottom left
as rows are increasing order, and columns as well. 

tc: O(log (mn))
sc: O(1)*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        
         //start at the right corner
            int r = 0;
            int c = col-1;
        
        while(r >= 0 && r < row && c >=0 && c <col)
        {
           if(target == matrix[r][c])
               return true;
            
            else if(target > matrix[r][c])
            {
                //increase the row, with the same col
                r++;
            }
            else
            {
                c--;
            }
        }
        return false;
    }
}