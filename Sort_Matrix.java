// Time Complexity : log(mn)
// Space Complexity : m + n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I had trouble at first, but the lecture helped


// Your code here along with comments explaining your approach
public class Sort_Matrix{

	public boolean searchMatrix(int[][] matrix, int target) {
		//find middle of matrix in order to do BFS
		int n_row = matrix.length;
		int n_column = matrix[0].length;
		int low = 0;
		int high = (n_row * n_column) - 1;

		while(low <= high){
			int mid = low + (high - low)/2;
			int r = mid / n_column;
			int c = mid % n_column;
			if(matrix[r][c] == target){
				return true;
			}
			else if(matrix[r][c] < target){
				low = mid + 1;
			}
			else{
				high = mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
		System.out.println("Hello");
	}
	
}



