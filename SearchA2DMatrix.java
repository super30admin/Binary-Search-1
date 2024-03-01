/**

  Thought Process - Since, in the matrix every row is sorted and last element of prev row is smaller than first element of
  nect row, we can imagine the entire matrix as a sorted 1D array. Since, a 1D array is like a one big row, we can evaluate
  or derive a corresponding index (row, col) for each element using / row & % row. And apply binary search on this imagined
  1D Array
  
  TC -> O(log(m X n)) = logm + logn, where m -> total no of cols and n -> total no of rows
  SC -> O(1), since we are not using any actual 1D array and just imagining and computing around it

  Pseudo Code ->
  1. if matrix is empty, return 
  2. l = 0 & h = mXn-1
  3. Binary search using these l & h
    3.1 find mid, then r = mid/n & c = mid%n
    3.2 compare matrix[r][c] with target and continue regular BS
**/

public class Solution{

  public boolean searchMatrix(int[][] matrix, int target){

    if( matrix.length == 0) return false; // Mistake done -> checking matrix.length == null Bad Operand
    
    // No of cols
    int m = matrix.length;
    // No of rows
    int n = matrix[0].length;

    int l = 0, h = m * n -1;
    
    //Start Binary Search
    while(l <= h){
      int mid = l + (h - l) / 2; // To avoid integer overflow
      int r = mid / n;
      int c = mid % n;
      if(matrix[r][c] == target)
        return true;
      else if( matrix[r][c] < target)
        l = mid + 1;
      else
        h = mid - 1;
    }
    return false;
  }
  
}
