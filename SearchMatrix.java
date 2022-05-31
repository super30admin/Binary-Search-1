/* Time Complexity : O(m*logn) , where m is rows and n is columns
 * Space Complexity : O(1
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0; i<m; i++){
            if(target >= matrix[i][0] && target <= matrix[i][n-1]){
                 int low = 0, high = n-1;
                 while(low <= high){
                     int mid = low+ (high - low)/2;
                     if(matrix[i][mid] == target) return true;
                     else if(matrix[i][mid] > target){
                         high = mid-1;
                     } else{
                         low = mid+1;
                     }
                 }
                 return false;
             }
         } 
        
        return false;
    }
}

/*
 // Time Complexity : O(logn*logm).
// Space Complexity : O(n*m) size.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int startrow = 0;
        int endrow = rows-1;
        int finalrow = 0;
        while(startrow<=endrow){
            int midrow = (startrow+endrow)/2;
            if(target>=matrix[startrow][0] && target<=matrix[startrow][cols-1]){
                finalrow = startrow;
                break;
            }
            else if(target>=matrix[midrow][0] && target<=matrix[midrow][cols-1]){
                finalrow = midrow;
                break;
            }
            else if(target>=matrix[endrow][0] && target<=matrix[endrow][cols-1]){
                finalrow = endrow;
                break;
            }
            else{
                if(target>=matrix[startrow][cols-1] && target<=matrix[midrow][0]){
                    endrow = midrow-1;
                }
                else{
                    startrow = midrow+1;
                }
            }
        }

        //Now we have our row where we have to do a binary search again!
        //System.out.println(finalrow);
        int startcol = 0;
        int endcol = cols-1;

        while(startcol<=endcol){
            int midcol = (startcol+endcol)/2;
            if(matrix[finalrow][startcol]==target){
                return true;
            }
            else if(matrix[finalrow][endcol]==target){
                return true;
            }
            else if(matrix[finalrow][midcol]==target){
                return true;
            }
            else{
                if(target>matrix[finalrow][startcol] && target<matrix[finalrow][midcol]){
                    endcol = midcol-1;
                }
                else{
                    startcol = midcol+1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 13));
        System.out.println(searchMatrix(matrix, 3));
    }
}
*/

/*
 class Solution {
    // Time complexity is O(logmn)
    // Space complexity is O(mn)
    // Solution is submitted with no errors
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int low = 0;
        int high =rowLen*colLen -1;
        while(low <= high) {
            int mid = low + (high -low)/2;
            int row = mid/colLen;
            int column = mid%colLen;
            if (matrix[row][column]==target) return true;
            if (matrix[row][column] > target) {
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return false;
    }
}
*/

/*
 //Time Complexity :O(m + n)
// Space Complexity : constant
// Did this code successfully run on Leetcode :Yes
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            //we'll check each row if target falls inside the row range
            if (matrix[i][j] > target) {
                i --;
            }
            else if (matrix[i][j] < target) {
                j ++;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
