class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high=m*n-1;
        int mid,r,c;
        if(matrix==null||matrix.length==0)
            {return false;}    
        
        while(low<=high)
        {
            mid=low+(high-low)/2;
            r=mid/n;
            c=mid%n;
            if(matrix[r][c]==target)
            {
                return true;
            }else if(matrix[r][c]>target)
            {
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }
}
