/*
 Time Complexity - O(mn) where m is no.of rows and n is no.of columns in the matrix
 Space Complexity - O(1) no extra memory used
 Has it passed all testcases on leetcode - Yes
 */

 /*
  As integers are sorted in each row from left to right and first element in each row is greater than last element of previous 
  row - We clearly know we could use a binary search here. But we need to flatten the matrix to a 1-D array and apply binary search.
  Mid can be calculated by low - 0 and high- which is number of elements in matrix -1 (as indexes start from 0).
  Once we have mid, we can derive the rowIndex and colIndex using the row size. If target element is at mid, we simply return true.
  Otherwise keep adjusting low/high depending on if the target element lies in the left side of mid or right side of mid.
*/
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = (m*n) -1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            int rowIndex = mid/n;
            int colIndex = mid%n;
            int midValue = matrix[rowIndex][colIndex];
            if(midValue == target){
                return true;
            }
            else if(midValue < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}
