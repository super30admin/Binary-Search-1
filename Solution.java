class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null ||  matrix.length==0)
            return false;
        
        int m=matrix.length;//number of rows
        int n=matrix[0].length;//number of columns
        int low=0;
        int high=m*n-1;
        
        while(low<=high){//low should always be less than high
            int mid=low+(high-low)/2;//To avoid integer overflow
            int row=mid / n;//get the mid value positioned row
            int col=mid % n; //get the mid value positioned col
            if(matrix[row][col]==target)
                return true;
            else if(target < matrix[row][col])//if target is less that mid, move high value to the left of mid
                high=mid-1;
            else //if target is greater that mid, move low value to the right of mid
                low=mid+1;
        }
        return false;
    }
}

//Time Complexity: O(log(m*n))
//Space Complexity: O(1)
