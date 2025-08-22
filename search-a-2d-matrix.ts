// Time complexity- lon(m*n), where m = length of the row and n = length of column
// Space complexity- O(1)
function searchMatrix(matrix: number[][], target: number): boolean {
	let row = matrix.length;
	let column = matrix[0].length;

	let low = 0;
	let high = row * column - 1;

	while (low <= high) {
		let mid = Math.floor((low + high) / 2);

		let r = Math.floor(mid / column);
		let c = mid % column;

		if (matrix[r][c] === target) return true;
		else if (matrix[r][c] < target) {
			low = mid + 1;
		} else {
			high = mid - 1;
		}
	}
	return false;
}
