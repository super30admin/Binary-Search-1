// Time Complexity : All the operations are done in O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* APPROACH 1:
Linear search with conditions such that:
1. if target value is less than the last value in row, then start searching towards the left in the same row.
2. if target value is more than the last value in row, then start searching in next row and do the same.

APPROACH 2:
Binary search on every low + linear search for the row by comparing first element of every row.
*/
public class Search2DArray {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowInd = 0;
        int colInd = matrix[0].length - 1;
        while(rowInd >= 0 && rowInd < matrix.length && colInd < matrix[0].length && colInd >= 0){
            if(target > matrix[rowInd][colInd]){
                rowInd++;
            } else if(target < matrix[rowInd][colInd]){
                colInd--;
            } else {
                return true;
            }
        }
        return false;
    }

//     public boolean searchMatrix(int[][] matrix, int target) {
//         if(matrix.length == 1){
//             return binarySearch(matrix[0], target);
//         }
//         for(int i=0; i<matrix.length-1; i++){
//             if(target>=matrix[i][0] && target<matrix[i+1][0]){
//                 return binarySearch(matrix[i], target);
//             }
//         }
//         return binarySearch(matrix[matrix.length-1], target);
//     }

//     public boolean binarySearch(int[] matrix, int target){
//         int low= 0;
//         int mid = 0;
//         int high = matrix.length - 1;
//         while(low<=high){
//             mid = (low+high)/2;
//             if(matrix[mid] == target){
//                 return true;
//             }else if(target > matrix[mid]){
//                 low = mid+1;
//             }else{
//                 high = mid-1;
//             }
//         }
//         return false;
//     }

    public static void main(String[] args){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;

        System.out.println("matrix1: " + searchMatrix(matrix, target));

        int[][] matrix2 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target2 = 13;

        System.out.println("matrix2: " + searchMatrix(matrix2, target2));
    }
}
