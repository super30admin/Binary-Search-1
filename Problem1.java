class Problem1{
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;
		int begin =0;
		int end = row*col-1;
		while(begin<=end) {
			int mid = begin + (end-begin)/2;
			int mid_val = matrix[mid/col][mid%col];
			if(mid_val == target) {
				return true;
			}else if(mid_val < target) {
				begin = mid+1;
			}else {
				end = mid -1;
			}
		}
		return false;
	}
}