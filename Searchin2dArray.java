public class Seachin2dArray {

	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0)
			return false;

		int c = matrix[0].length;
		int r = matrix.length;

		int low = 0;
		int high = c * r - 1;
		while (low <= high) {

			int mid = low + (high - low) / 2;

			int rowIndex = mid / c;
			int colIndex = mid % c;

			if (matrix[rowIndex][colIndex] == target)
				return true;
			else if (target < matrix[rowIndex][colIndex])
				high = mid - 1;
			else
				low = mid + 1;

		}

		return false;

	}

}