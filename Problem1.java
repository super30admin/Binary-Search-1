//Time Complexity: O(log m*n)
//Space Complexity O(1)
//Yes the code ran successfully in leetcode
//No problem faced
//74. Search a 2D Matrix
//Trying out ssh for sawanch-test
public class Problem1 {
    
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0)// null condition check
        return false;

        int n=matrix.length;//no of rows
        int m=matrix[0].length;// no of columns
        int low=0;
        int high=n*m-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;//mid calculation
            int row=mid / m; // getting row of mid
            int col=mid % m; // getting col of mid
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                low=mid+1;// moving to right side
            }
            else{
                high=mid-1;// left side
            }
        }
        return false;
    }
}
