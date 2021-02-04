//Time Complexity: O(N) (Using two pointers)
//Space Complexity: O(1)

//Brute force approach will be to iterate through each and every element till we find our target - O(N^2)
//Two pointer approach reduces the number of searches by comparing the current element with the required target - O(N)

class MatrixSearch
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int row = 0;
        int col = matrix[0].length - 1;

        while(row < matrix.length && col >= 0)
        {
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] < target)
                row++;
            else
                col--;
        }
        return false;
    }
}


//Time Complexity: O(log(M*N))
//Space Complexity: O(1)

//Leetcode : 0 ms
//Approach: Using binary search on imaginary flattened matrix and moving low and high pointers according to the mid value 
//and converting the mid into corresponding row and column in the matrix using mid/n and mid%n.



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       if(matrix.length == 0 || matrix[0].length == 0)
            return false;
       int m = matrix.length;
       int n = matrix[0].length;
       int low = 0;
       int high = m*n - 1;
       
       while(low <= high)
       {
           int mid = low + (high - low)/2;
           int r = mid / n;
           int c = mid % n;
           if(matrix[r][c] == target)
               return true;
           else if(matrix[r][c] < target)
               low = mid+1;
           else
               high = mid-1;
       }
       return false; 
    }
}