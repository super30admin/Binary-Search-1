//time complexity: O(log(m)+log(n)) where m and n are number of columns and rows of the matrix.
//Space complexity: O(1) the data assigning is independent of each iteration so it's constant.
//Worked in leetcode

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {  // based on number of rows and columns getting the total number of values in matrix and performing normal binary search.
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0, r= n*m-1;
        int mid = l+(r-l)/2;
        int i = mid/m, j = mid%m;
        while(l<=r)												//getting indexes using division and modules operations.
        {
            if(matrix[i][j]==target)
                return true;
           else if(matrix[i][j]<target )
            {
                l = mid+1;
            }
            else
            {
                r = mid-1;
            }
            
            mid = l+(r-l)/2;       
            i = mid/m; j = mid%m;
            
        }
        
        return false;
    }
}