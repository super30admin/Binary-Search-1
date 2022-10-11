// TC: O(log(mn))
// SC: O(1)

public class TwoDimSortedArraySearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end   = rows*cols-1;
        // treat it is as Binary search since all elements are sorted
        // we need to find effective mid as rows*cols
        //convert effectective mid to arr[row][col] by determining row and col
        //row = mid/total-cols and col= mid%total-cols

        while (start <=end ){
            int mid = (start + end)/2;
            int row = mid/cols;
            int col = mid%cols;

            if(matrix[row][col] == target){
                return true;
            }
            if(matrix[row][col] < target){
                start = mid+1;
            }
            if(matrix[row][col] > target){
                end = mid-1;
            }

        }

        return false;

    }

    public static void main(String [] args){
        int [][] arr =new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        System.out.println(searchMatrix(arr, 4));
        System.out.println(searchMatrix(arr, 1));
        System.out.println(searchMatrix(arr, 11));
        System.out.println(searchMatrix(arr, 34));

    }
}