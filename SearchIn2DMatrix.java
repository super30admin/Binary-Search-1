/**
 *  Time Complexity: O(m * n) as we apply binary search on all the elements in the matrix
 * 
 *  Space Complexity: O(1) as we don't take any linear space
 */

/**
 * In this apprach we convert 2D array into 1D array and then apply Binary Search
 * When we divide totalElements / no. of cols, we get no. of rows.
 * We calculate mid / total cols which gives us row of mid
 * then we do mid % cols , which gives use col of mid
 */

class Solution {

    public boolean search(int matrix[][], int target){
        
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = (m * n) - 1;

        while(low <= high){

            int mid = (low + (high - low) / 2);

            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return false;
    }
}