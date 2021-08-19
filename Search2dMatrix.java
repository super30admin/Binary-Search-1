// TIME: O(logn)
// SPACE: O(1)
// SUCCESS on LeetCode

public class Search2dMatrix {
    // Its simply using binary search on a m*n size array.
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int arrLength = matrix[0].length;
        int end = matrix.length * arrLength - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midEl = matrix[mid / arrLength][mid % arrLength];
            if (target == midEl) {
                return true;
            } else if (target < midEl) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        Search2dMatrix searchMatrix = new Search2dMatrix();
        int[][] matrix = new int[][] {
            { 1, 5, 7, 9 }, 
            { 11, 15, 16, 21 },
            { 25, 29, 32, 35 }
        };
        System.out.println(searchMatrix.searchMatrix(matrix, 7));
    }
}
