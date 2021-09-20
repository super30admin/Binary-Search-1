// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, col = matrix[0].length, middle, mid_element, left = 0, right = rows * col - 1;
        while(left <= right){
            middle = left + (right - left) / 2;
            mid_element = matrix[middle/col][middle%col];
            if(mid_element == target)   return true;
            else if(mid_element < target) left = middle + 1;
            else if(mid_element > target) right = middle - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Matrix().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 11));
    }

}
