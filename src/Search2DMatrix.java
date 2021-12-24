// Time Complexity :O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int column = matrix[0].length;
        int l = 0;
        int h = row-1;
        while(l<=h)
        {
            int mid = l + (h-l)/2;
            if(matrix[mid][column-1] > target) {
                if(h<row && h>=0)
                    h = mid-1;
            }
            else if(matrix[mid][column-1] < target){
                if(l+1<row && l+1>=0)
                    l = mid+1;
                else{
                    break;
                }
            }
            else{
                return true;
            }
        }
        row = l;
        l =0;
        h =column-1;
        while(l<=h)
        {
            int mid = l + (h-l)/2;
            if(matrix[row][mid] > target)
            {
                h = mid-1;
            }
            else if(matrix[row][mid] < target){
                l = mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}