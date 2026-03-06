// TimeComplexity: O(logmn)
// SpaceComplexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m*n -1;
        int mid;

        while (low <= high) {
            mid = low + (high-low)/2;

            if (target == matrix[mid/n][mid%n]) {
                return true;
            }

            if (target < matrix[mid/n][mid%n]) {
                high = mid -1;
            } else {
                low = mid+1;
            }
        }
        return false;
    }
}

// TimeComplexity: O(m+logn)
// SpaceComplexity: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(target<matrix[0][0] || target > matrix[m-1][n-1]) return false;
        int row =-1;
        for(int i =0; i<m; i++) {
            if(target<=matrix[i][n-1]) {
                row = i;
                break;
            }
        }
        int low = 0;
        int high = n-1;
        while(low<=high) {
            int mid = low+ (high-low)/2;
            if(matrix[row][mid] == target) return true;
            if(matrix[row][mid]<target) {
                low=mid+1;
            } else {
                high = mid-1;
            }
        }
        return false;
        
    }
}
