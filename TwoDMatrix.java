//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    //TwoDMatrix
    int[][] mat;
    int m,n;
    public boolean searchMatrix(int[][] matrix, int target) {
        m=matrix.length; n=matrix[0].length;
        mat=matrix;
        return search(0,m*n-1,target);
    }

    public boolean search(int l,int r, int target)
    {
        int mid=l+(r-l)/2; //To avoid integer overflow
        int row=mid/n,col=mid%n;
        if(l>r)
            return false;
        if(mat[row][col] == target)
        {
            return true;
        }
        else if(mat[row][col ] > target)
        {
            return search(l, mid-1, target);
        }
        else //if(mat[mid/m ][mid%m ] < target)
        {
            return search(mid+1, r, target);
        }


    }


}
