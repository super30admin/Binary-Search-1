// Time Complexity : O(log(m*n)) m and n are number of rows and columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        //consider the 2D array to be a 1D array and use binary search
        int l=0, h=(n*m)-1;

        int midIndex, midElement;

        while(l<=h)
        {
            midIndex = (l+h)/2;
            midElement = matrix[midIndex/m][midIndex%m];

            if(midElement==target)
                return true;
            else if(midElement > target)
                h = midIndex-1;
            else
                l = midIndex+1;
        }
        return false;
    }
}
