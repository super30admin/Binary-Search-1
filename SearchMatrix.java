/*
Time: O(logMN) where M=rows and N=columns
Space: O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class SearchMatrix {

    public boolean seachMatrix(int[][] matrix, int target) {
        if (matrix.length < 1)
            return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows * columns - 1;

        while (left <= right) {
            int midpointIndex = left + (right - left) / 2;
            int midpointValue = matrix[midpointIndex / columns][midpointIndex % columns];

            if (target == midpointValue)
                return true;

            else if (target < midpointValue)
                right = midpointValue - 1;

            else if (target > midpointValue)
                left = midpointValue + 1;

        }

        return false;
    }

}
