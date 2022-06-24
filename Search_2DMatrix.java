//Time Complexity: O(log(m*n))
//Space Complexity: O(1)
//Code successfully run on LeetCode

public class Search_2DMatrix {
	
public boolean searchMatrix(int[][]matrix, int target) {
		
		int row, col;
		int r = matrix.length;
		int c = matrix[0].length;
		
		int low = 0;
		int high = r*c -1;
		
		while(low <= high) {
			
			int mid = low + (high-low)/2;
			
			row = mid / c;
			col = mid % c;
			
			if(matrix[row][col] == target)
				return true;
			
			if(matrix[row][col] < target)
				low = mid+1;
			
			else
				high = mid-1;	
		}
		return false;
	}

}
