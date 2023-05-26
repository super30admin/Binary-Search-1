

/* Time Complexity:  O(log(m * n)) */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length==0)
        return false;

        int m=matrix.length;
        int n= matrix[0].length;
        int low=0, high=m*n-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int row=mid/n;
            int column=mid%n;

            if(matrix[row][column]==target)
                return true;
            else if(matrix[row][column]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return false;
    }
}