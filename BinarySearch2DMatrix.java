class BinarySearch2DMatrix {
	/*
	Time Complexity: O(n)
	Space Complexity: O(1)
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		//initialize the variables
		int i=0,j=0;

		//iterate only the outer loop.
		//Check for the last value from the matrix column and look into the row only if last val > target
		for(i = 0; i < matrix.length; i++) {

			//check if target < last element of a row
			if (target <= matrix[i][matrix[0].length-1]) {
				//if true -> iterate/traverse the row else do not traverse the row.
				for (j=0; j< matrix[0].length;j++){
					if (target == matrix[i][j]){
						return true;
					}
				}
			}
		}
		return false;
	}
}