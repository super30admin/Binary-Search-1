//Did this code successfully run on Leetcode :  Yes
//Any problem you faced while coding this :  No
//Time complexity - O(logn)
//Space complexity - O(1)
public class Seach2DLC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length * matrix[0].length-1;

        System.out.println(matrix.length);
        System.out.println(matrix[0].length - 1);
        while(left <= right){
            int mid = left + (right - left) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if(matrix[row][col] == target)
                return true;

            else{
                if(matrix[row][col] < target){
                    left = mid +1;
                }
                else
                    right = mid -1;
            }
        }
        return false;
    }
}