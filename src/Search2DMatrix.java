
/**
 * @author Aditya Sinha	
 *
 */
// we will try to treat the 2D array as 1D array, as it is sorted one
// Space Complexity : O(1)
// Time Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
public class Search2DMatrix {
	  public boolean searchMatrix(int[][] matrix, int target) {
	        int m = matrix.length;
	        int n = matrix[0].length;

	        int low = 0, high = m*n-1;
	        while(low <= high) {
	            int mid = low + (high - low) / 2;
	            int r = mid / n;
	            int c = mid % n;

	            if(matrix[r][c] == target) {
	                return true;
	            } else if(matrix[r][c] > target) {
	                high = mid - 1;
	            } else {
	                low = mid + 1;
	            }
	        }
	        return false;
	    }
}

 class Search2DMatrixmain {

	 public static void main(String[] args) {
		 Search2DMatrix sdm = new Search2DMatrix();
		 int[][] matrix = {
				    {1, 3, 5, 7},
				    {10, 11, 16, 20},
				    {23, 30, 34, 60}
				};
		 
		 System.out.println("target exist or not - " + sdm.searchMatrix(matrix, 60));
	}
}
