/*
    Time Complexity
    O(log(mn))
    Space Complexity
    O(1)
*/

class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        //Rows
        int m = matrix.length;

        //Columns
        int n = matrix[0].length;

        //Set up pointers
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {

            int mid = (high - low) + low / 2;
            //Decode mid value to find row and col
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;

                //Move pointers accordingly
            } else if (matrix[row][col] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return false;

    }
}