public class searchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // Row is mid devide by numbers
            int r = mid / n;
            // Column is mid modulo by numbers
            int c = mid % n;


            if (matrix[r][c] == target)
                return true;
            // target is less than target then increase the start
            else if (matrix[r][c] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 20;
        System.out.println(searchMatrix(matrix, target));
    }
}
