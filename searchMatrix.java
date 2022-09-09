class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        
        int m=matrix.length;
        int n=matrix[0].length;
        int l=0;
        int h=m*n-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            int mid_ele=matrix[mid/n][mid%n];
            if(mid_ele==target)
                return true;
            else if(mid_ele>target)
                h=mid-1;
            else
                l=mid+1;
        }
        
        return false;
    }
}