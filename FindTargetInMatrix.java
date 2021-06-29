public class FindTargetInMatrix
{
	public boolean searchMatrix(int[][] matrix, int target)
	{
		int rows = matrix.length;
		int columns = matrix[0].length;
		int low =0, high = (rows*columns) -1, mid =0, r=0, c=0;
				
		//edge case
		if(matrix ==null || matrix.length == 0)
			return false;
		
		while(low <= high)
		{
			//calculating mid
			mid = low + (high - low)/2;
			r = getRowIndex(mid, columns);
			c = getColIndex(mid, columns);
			
			if(matrix[r][c] == target)
			{
				return true;
			}
			else if(matrix[r][c] > target)
			{
				high = mid -1;
			}
			else
			{
				low = mid + 1;
			}
		}
		return false;
	}
	
	private int getRowIndex(int mid, int columns)
	{
		return mid / columns; 
	}
	
	private int getColIndex(int mid, int columns)
	{
		return mid % columns; 
	}
	
}



/*
approach: we consider the matrix as a flattened array. Because it stated that matrix is orted, in order to apply the binary search, get low and high index and get the mid. now, we need to find the row and column index from the mid. 

so, row is mid/ total columns  & column is mid%total columns. 

Now we apply binary search, check if matrix on given row and col indices has value ==,>, < target and do the relevant operation. 

time complexity : O(log N)
Space Complexity : O(1) (No auxiliary space used. )






*/