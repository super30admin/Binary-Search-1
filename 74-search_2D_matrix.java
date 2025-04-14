//Approach 1
//There are multiple approaches with various time complexities we would be concentraing on log(n*m) approach
//Overall time complexity: O(log(m*n))
//Overall space complexity: O(1)
class Solution {
    //Considering the 2D matrix as a 1-D array
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int m = matrix.length; //rows
        int n = matrix[0].length;  //columns

        int low = 0;
        int high = m*n - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target) return true;
            else if(target < matrix[row][col]) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }
}


//Approach 2
//Binary search on rows and on columns
class Solution {
    //Considering the 2D matrix as a 1-D array
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int m = matrix.length; //rows
        int n = matrix[0].length; //cols

        int low = 0;
        int high = m - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(target >= matrix[mid][0] && target <= matrix[mid][n -1]) return searchRow(matrix, mid, n-1, target);
            else if(target < matrix[mid][0]) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }

    private boolean searchRow(int[][] matrix, int r, int high, int target){
        int low = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[r][mid] == target) return true;
            else if(matrix[r][mid] > target) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }
}
