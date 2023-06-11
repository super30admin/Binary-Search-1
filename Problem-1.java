class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Time Complexity:-O(logn)//Because we using Binary search to solve the problem.
        //Space Complexity:-O(1) //Not taking any extra memory to solve the problem except auxiliary memory.
        if(matrix.length == 0) return false;
        int m=matrix.length;
        int n=matrix[0].length;
        int low =0;
        int high=m*n-1;
        while(low<=high)
        {
            //Applying Binary Search here to the give matrix
            int mid = low + (high-low)/2;
            int r=mid/n;// To calculate the row
            int c=mid%n;// To calculate the Column
            if(matrix[r][c]==target) return true;
            else if(target<matrix[r][c]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}