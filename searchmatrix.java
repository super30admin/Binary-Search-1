class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0 || matrix==null)
        {
            return false;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high=(m*n)-1;
        while(high>=low)
        {
            int mid=low+(high-low)/2;
            int r=mid/n;
            int c=mid%n;
            if (matrix[r][c]==target)    return true;
            else if (matrix[r][c]>target)   high=mid-1;
            else low=mid+1;    
        }
      return false;  
    }
}