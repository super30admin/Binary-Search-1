//search-a-2d-matrix
//Time Complexity:O(log (m*n))
//Space Complexity:O(1)
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0)
        {
            return false;
        }
        //apply binary search on mattrix
        int m=matrix.length;//no of rows
        int n=matrix[0].length;//no of cols
        int low=0;
        int high=m*n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int r=mid/n;
            int c=mid%n;
            if(matrix[r][c]==target)
            {
                return true;
            }
            else if(matrix[r][c]<target)
            {
                low=mid+1;
            }
            else if(matrix[r][c]>target)
            {
                high=mid-1;
            }
        }

        return false;
    }
}