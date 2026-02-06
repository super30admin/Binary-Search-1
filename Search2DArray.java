class Search2DArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        int LEFT = 0;
        int RIGHT = matrix.length - 1;
        int MID;
        int ROW = 0;
        // find the correct row
        while (LEFT < RIGHT) {
            MID = (LEFT + RIGHT + 1) / 2;
            if(matrix[MID][0] <= target && target <= matrix[MID][matrix[MID].length - 1]) {
                ROW = MID;
                break;
            }
            if (matrix[MID][0] > target) {
                RIGHT = MID - 1;
            } else {
                LEFT = MID;
            }
            ROW = LEFT;
        }
        // find the correct column
        LEFT = 0;
        RIGHT = matrix[ROW].length - 1;
        while (LEFT < RIGHT) {
            MID = (LEFT + RIGHT + 1)/2;
            if (matrix[ROW][MID] == target) {
                return true;
            }
            if (matrix[ROW][MID] > target) {
                RIGHT = MID - 1;
            } else {
                LEFT = MID;
            }
        }
        return matrix[ROW][LEFT] == target ? true : false;
    }
}