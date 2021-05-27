//Implemented in two approaches
public class SearchIn2DMatix {

    // TC  : Time Complexity would be O(log(mn)) as we are basically doing binary search on an array of length m*n
    // SC : Space complexity would be O(1)
    // Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = m*n-1;

        //for a matrix of size 4 x 3, if we want to access the element at [2][1], then memory address is calculated as 2*3+1 = 7,
       // hence here we are just reversing the calculation. We have mid, and have to find i, j for [i][j] which is i = mid/n and j=mid%n

        while(left<=right)
        {
            int mid = (left + right)/2;
            int element = matrix[mid/n][mid%n];

            if(target <element)
                right = mid-1;
            else if(target >element)
                left = mid+1;
            else
                return true;

        }
        return false;
    }

    //TC : O(m+n) in the worst case
    //SC : O(1)
    // Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
    public boolean searchMatrix_new(int[][] matrix, int target)
    {
        int rows = 0;
        int cols = matrix[0].length-1;

        //as the elements in the matrix are in ascending order along the rows, we need to first find the row where the target belongs
        //and then find the correct column in that row
        while(rows < matrix.length && cols >= 0)
        {
            if(target > matrix[rows][cols])
                rows++;
            else if(target < matrix[rows][cols])
                cols--;
            else
                return true;
        }

        return false;

    }



}
