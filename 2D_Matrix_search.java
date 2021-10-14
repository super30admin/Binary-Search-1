// Time Complexity : M + log(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
import java.util.*;

class matrix_Search {

    public  static boolean searchMatrix(int[][] matrix, int target) 
        {
            int row = matrix.length;
            int column = matrix[0].length;

            int start = 0;
            int end = row-1;
            int mid = 0;
            int targetRow = 0;

            while(start <= end) 
            {
                if(matrix[start][column-1] >= target) 
                {
                    targetRow = start;
                    break;
                }
                else 
                {
                    start++;
                }
            }

            start = 0;
            end = column-1;

            while(start <= end) 
            {
                mid = start + (end-start)/2;
                if(matrix[targetRow][mid] == target)
                    return true;
                else if(matrix[targetRow][mid] < target)
                {
                    start = mid+1;
                }
                else
                {
                    end = mid-1;
                }
            }
            return false;
        }
   
    public static void main(String args[]) 
        {
           int arr[][] = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
           boolean result;
           result = searchMatrix(arr, 1);
           if (result == true) {
               System.out.println("Target found");
           }
           else {
               System.out.println("Target not found");
           }
        }
}


