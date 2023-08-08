public class SortedArrayOfUnknownSize {

    public static void main(String[] args) {

        int[][] arr = {
                { 1, 2, 3, 4 },
                { 4, 5, 6, 7 },
                { 9, 5, 6, 4 }
        };

        int target = 1;

        SortedArrayOfUnknownSize obj = new SortedArrayOfUnknownSize();

        boolean obj1 = obj.searchMatrix(arr, target);

        System.out.println("find the value " + obj1);

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int r = mid / n;
            int c = mid % n;

            if (matrix[r][c] == target)
                return true;

            else if (matrix[r][c] > target) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return false;

    }
}
