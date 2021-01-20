/*  Successfully ran on leetcode
*   Time Complexity: O(log(m*n))
*   Space Complexity: O(1)
*
*
* */


public class Search2DMatrix {
    public static void main(String args[]){
        int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int matrix1[][] = {{1},{3}};
        int target = 13;
        System.out.println(searchMatrix(matrix, target));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length * matrix[0].length -1;
        return binarySearch(target,matrix,low,high, matrix[0].length);
    }

    public static boolean binarySearch(int target, int[][] matrix, int low, int high, int n){
        if(high >= low){
            int mid = (low+high)/2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target)
                return true;
            else if(target > matrix[row][col])
                return binarySearch(target, matrix, mid+1, high, n);
            else
                return binarySearch(target, matrix, low, mid-1, n);
        }
        return false;
    }
}
