package BinarySearch;

/*
  Time complexity : o(log n)
  Space complexity : o(n)
  Did this code run succesfully in leetcode : yes
  problems faces : no
  Assume the matrix as sorted linear array . but without actually createing array.
  Find the pivot element by dividing with column size. pivot/n and pivot%n
*/
public class SearchSortedMatrix {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 50 } };
        int target = 11;

        System.out.println(searchMatrix(matrix, target));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        int pivot;

        while (left <= right) {
            pivot = left + (right - left) / 2;
            if(matrix[pivot/n][pivot%n] == target  )
            {
                return true;
            }
            else if(matrix[pivot/n][pivot%n] > target  )
            {
                right = pivot-1;
            }
            else if(matrix[pivot/n][pivot%n] < target  )
            {
                left = pivot+1;
            }
        }

        return false;
    }
}
