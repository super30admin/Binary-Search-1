// TC : O(log n)
// SC : O(1)

class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row= matrix.length;
        int col=matrix[0].length;
        int start=0;
        int end=row*col-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            int midd=matrix[mid/col][mid%col];
            if(target==midd)
            {
                return true;
            }
            else
            if(target<midd)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return false;
    }
}
