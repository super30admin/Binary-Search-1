package BinarySearch1;

//Time Complexity : O(logn) for searching using binary search
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Imagine 2D matrix as a linear array and find row and column indices over column
//Do binary search algorithm, if matrix[r][c] is equal to target then return true otherwise move low and head pointers accordingly.



public class SearchIn2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { {1,3,5,7},{10,11,16,20},{23,30,34,60} };
		int target = 21;
		
		boolean isPresent = searchIn2DMatrix(matrix,target);
		
		System.out.println(isPresent);
	}

	private static boolean searchIn2DMatrix(int[][] matrix, int target) {
		// TODO Auto-generated method stub
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int low = 0;
		int high = m*n -1;
		int mid = 0;
		
		int r, c;
		
		while(low<=high) {
			mid = low + (high-low)/2;
			r = mid/n;
			c = mid%n;
			if(matrix[r][c] == target) {
				return true;
			}else if(matrix[r][c] < target) {
				low = mid+1;
			}
			else {
				high = mid-1;
			}
			
		}		
		return false;
	}

}
