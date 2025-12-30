// TC - O(log(n)) + O(log(m))
// SC - O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;
        int cols = matrix[0].length-1;
        int binarySearchRow = -1; // Assign it to -1 initially. 

        while (low <= high) {
            int mid = low + (high -low)/2;
            System.out.println("Mid val: "+ mid);
            // Check if the element is within the mid'th row
            if ( matrix[mid][0] <= target && matrix[mid][cols] >= target) {
                binarySearchRow =  mid;
                System.out.println("binarySearchRow: " + binarySearchRow);
                break;
            }
        
            else if (matrix[mid][0] > target) { 
                high = mid -1; 
                System.out.println("Present in row lesser than: " + high);

            } else {
                low = mid +1;
                System.out.println("Present in row higher than: " + low);
            }
            
        }
        if (binarySearchRow < 0) return false; // if the element is not within the range of  any row elements return false.


        // if the element is within the range of elements in binarySearchRow then perform BS on that row.
        low = 0; 
        high = cols;
        while (low <= high) {
            int mid = low + (high - low)/2;

            if (matrix[binarySearchRow][mid] == target) return true;
            if (matrix[binarySearchRow][mid] < target) {
                low = mid +1;
            } else {
                high = mid -1; 
            }
        }
        return false;
    }
}