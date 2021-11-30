// Time Complexity :O(log mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0)
            return false;
        int m= matrix.length;
        int n=matrix[0].length;
        int l=0;
        int h=m*n-1;
        int mid;
        int r,c;
        while(l<=h)
        {
            mid=l+(h-l)/2;
            r=mid/n;
            c=mid%n;
                if(matrix[r][c]==target)
                    return true;
            else if(matrix[r][c]<target)
                l=mid+1;
            else
                h=mid-1;

        }
        return false;
    }
}
