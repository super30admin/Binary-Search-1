// Time Complexity: O(log n), where n is the number of elements in the 2D matrix
// Space Complexity: O(1), no use of auxillary data structure
// Running on Leetcode: yes
class Solution
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        //size of the matrix
        int m = matrix.length; //#of rows is m
        int n = matrix[0].length; //# of columns
        
        //assign pointers, visualizing the 2D matrix as a 1D array
        int low = 0;
        int high = (m*n)-1; //same as length of array-1. total length of 2D is m*n
            while (low <= high)
            {
                int mid = low + (high - low)/2;
                //converting the mid pointer ofthe 1D array to 2D matrix
                int row = mid/n;
                int col = mid%n;
                if(matrix[row][col]==target)
                {
                    return true;
                }
                //target is smaller than the value at the mid pointer, move the high pointer to mid-1
                else if (target < matrix[row][col])
                {
                    high = mid-1;
                }
                else //target is greater than the value at mid, move the low pointer to mid+1
                {
                    low = mid+1;
                }
            }
        return false;
    }
}
