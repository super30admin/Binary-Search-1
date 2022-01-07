// Time complexity  = O(log(m*n)) where m,n are no of rows and columns. Space complexity is O(1) as no new space is utilized

// Approach
// The matrix is converted into a 1D array and Binary search is used to search elements
// To convert the 2d Array matrix to 1d Array, we have used the number of cols and did modulo and division to find out the exact corresponding position of array element in the matrix 

class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int right = m * n - 1;
        while (left<=right){
            int mid = left + (right-left)/2;
            int r = mid / n;
            int c = mid % n;
            if(matrix[r][c] == target) return true;
            else if(target < matrix[r][c]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            
        }
        return false;
    }

    public static void main(String args[]){
         
    }
}