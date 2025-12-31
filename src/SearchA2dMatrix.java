
public class SearchA2dMatrix {

	// Time complexity is O(n), n=rows*cols
	// Space complexity
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix[0].length == 0)
			return false;

		int rows = matrix.length, cols = matrix[0].length;
		// because all rows are sorted and every row has values
		// smaller or equalr to next row we can consider a matrix as a 1d array of
		// lentgh rows * cols -1
		//
		int low = 0, high = (rows * cols) - 1, mid = 0, rowInd = 0, colInd = 0;

		while (low <= high) {
			mid = low + (high - low) / 2;
			// we need to convert the mid to row index and col index to find the value in 2D
			// matrix
			rowInd = mid / cols;
			colInd = mid % cols;
			if (matrix[rowInd][colInd] == target) {
				return true;
			} else {
				if (matrix[rowInd][colInd] > target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return false;

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
		SearchA2dMatrix search = new SearchA2dMatrix();
		boolean response = search.searchMatrix(matrix, 2);
		System.out.println(" 2 Found?=" + response);
		response = search.searchMatrix(matrix, 0);
		System.out.println(" 0 Found?=" + response);

	}
}
