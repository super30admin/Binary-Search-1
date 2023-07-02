// TC :  O(log (m*n))
// SC :  O(1)
class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = m*n - 1;

        while(i <= j) {
            int mid = i + (j-i) / 2;
            int midVal = matrix[mid/n][mid%n];

            if(midVal == target) 
                return true;
            else if(target < midVal) 
                j = mid-1;
            else
                i = mid+1;
                
        }
        return false;
    }
}
