class MartrixSearch {
         public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix.length == 0) return false;
            int m = matrix.length;
            int n = matrix[0].length;
            int low = 0; 
            int high = m - 1;
            int rIdx = 0; 
            while(low <= high){
                int mid = low + (high - low)/2;
                if (matrix[mid][0] <= target && matrix[mid][n-1] >= target){
                    rIdx = mid;
                    break;
                } else if(matrix[mid][n-1] < target){
                    low = mid + 1;
                } else {
                    high = mid -1;
                }
            }
            low = 0; high = n -1;
            while(low <= high){
                int mid = low + (high - low)/2;
                if(matrix[rIdx][mid] == target){
                    return true;
                } else if(matrix[rIdx][mid] > target){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }
    }