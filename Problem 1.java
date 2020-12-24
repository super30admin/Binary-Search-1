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