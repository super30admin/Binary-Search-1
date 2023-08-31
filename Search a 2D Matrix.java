class Solution {
    // As the question mentions that we need to complete the search in O(log(m*n)) time which indicates that we need to perfrom Binary search.
    public boolean searchMatrix(int[][] matrix, int target) {

// Edge case is the matrix is null or empty then we wont get target value.
        if (matrix==null || matrix.length==0)
        {
            return false;
        }

       // rows in the matrix
       int rows = matrix.length;
       // cols in the matrxi
       int cols = matrix[0].length;
       // low: initized to beginning of matrix
       int low = 0;
       // high: intialized to last element of the matrix
       int high = (rows * cols)-1;
       


       while(low<=high)
       {
           int mid = low + (high-low)/2; // mid is declared like this to avoid Integer Overflow problem. In languages like Java, C, C++ we have to take care of this ourself. Python Javscript we dont need to.

           int row = mid/cols; // row for element at mid index
           int col = mid%cols; // col for element at mid index

// If the element at mid index is less than target thus we need to select right side of the matrix so low = mid+1
           if(matrix[row][col]<target)
           {
              low = mid+1;
           }
           // If the element at mid index == target so we found the element and return true
           else if (matrix[row][col]==target)
           {
              return true;
           }
           // If the element at mid index is greater than target thus we need to select left side of the matrix so high = mid-1
           else {
             high = mid -1;
           }
       }
       // If the code reached here this means we dont have target in the given matrix and thus we return false.
       return false;
        
    }
}
