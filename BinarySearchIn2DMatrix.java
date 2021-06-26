// Time Complexity :O(log(MN))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//The matrix is saved in memeory as 1 Dimensional array
//JVM calculate the index of mid of matrix by formula row*n+column
//We know where the midpoint is /we know the index, but we need to find the position in matrix where the index is.
//For JVM, matrix [m][n] is the input and index is the output, but for us to code, we know the mid index by our eyes,but we need to find the corresponding row and column programmatically
//Row calculation = mid index /noOfCoumns (Example: 5/4 =1)
//COlumn Calculation = mid index % noOfColumns (Example: 5%4=1)
//From above we derived the mid index position as [1][1]


//assuming Flattening the matrix to list and find the mid index 
// then do binary search


class BinarySearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;   
            
            //initilazing the matrix
            int m = matrix.length, n = matrix[0].length;
            int low = 0, high = m*n-1;
            while(low <= high) {
                //Calculating the mid
                int mid = low + (high - low)/2;
                //calculating row & column 
                int row = mid/n;
                int column = mid%n;
                
                if(matrix[row][column] == target)
                    return true;
                
                else if(matrix[row][column] > target)
                    high = mid-1;
                else
                    low = mid -1;
                
        }
            return false;
    }
}

