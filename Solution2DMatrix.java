// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low=0;
        int high=m*n-1;

        while(low<=high){
            int mid = low+(high-low)/2;

            int x =mid/n;
            int y =mid%n;
            if(matrix[x][y]==target)return true;

            if(matrix[x][y]>target){
                high=mid-1;
            } else {
                low=mid+1;
            }

        }
        return false;
    }
}

