// Time Complexity : O(m + logn) because we are traversing every row and checking for target
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class Search2DMatrix1 {
    public boolean searchMatrix(int[][] matrix, int target) {

        //base condition
        if(matrix.length == 0 || matrix == null){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++){ //Travesring every row

            if(target >= matrix[i][0] && target <= matrix[i][n -1]){ // Checking every row for target
                int low = 0;
                int high = n - 1;

                while(low <= high){ //Binary Search

                    int mid = low + (high - low)/2;

                    if(matrix[i][mid] == target){
                        return true;
                    }else if(matrix[i][mid] > target){
                        high = mid - 1;
                    }else{
                        low = mid + 1;
                    }
                }

                return false;
            }
        }

        return false;
    }
}
