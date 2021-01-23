class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n= matrix.length; int m= matrix[0].length;
        int low=0;
        int high =n*m -1;

        while(low<=high){
            int mid= low + (high-low)/2;

            int i= mid / m;
            int j= mid % m;

            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j]<target){
                low=mid+1;
            }
            else{
                high= mid-1;
            }
        }
        return false;
    }
}
