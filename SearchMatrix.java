/* 
Time Complexity : O(log(mn)) where m = length of the row; n = length of the column
*/

/*
  This solution passed all the test cases on leetcode
 */

 /*
   Approach: 
   1. Find the mid index of the matrix and with the help of this index find the pivot element
   Pivot element divides the matrix into two halves.
   2. With the help of pivot element, implement divide and conquer algorithm at pivot element
   (use binary search algorithm) to find the requested element
   3. If the requested element is found then return true else return false
 */
 
class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        if(rowLength == 0) return false;
        int columnLength = matrix[0].length;
        
        int left = 0, right = rowLength * columnLength - 1;
        int midIndex, pivot;
        while(left <= right){
            midIndex = (left + right)/2;
            pivot = matrix[midIndex / columnLength][ midIndex % columnLength];
            if(target == pivot) return true;
            else {
                if(target < pivot) right = midIndex - 1;
                else left = midIndex + 1;
            }
        }
        return false;
    }
}