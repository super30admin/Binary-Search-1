// Time Complexity : O(log(m*n)) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class SearchInASorted2DArray {
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		
		int m = matrix.length; //total rows
		int n = matrix[0].length; //total columns
		
		int low = 0, high = (m*n)-1; 
		
		int mid = low+(high-low)/2;	//find mid element
		int rowId = mid/n, colId = mid%n; //find the index of mid element in 2D matrix
		
		while(low <= high)
		{
			if(target == matrix[rowId][colId])
				return true;
			else if(target < matrix[rowId][colId]) //search in left half
			{
				high = mid-1;
			}
			else						//search in right half
				low = mid+1;	
		
			mid = low+(high-low)/2;
			rowId = mid/n; colId = mid%n;
		}
		return false;
	}

	public static void main(String[] args) {
		int [][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println(searchMatrix(arr,15));
	
	}

}
