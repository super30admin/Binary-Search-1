// Time Complexity : O(m+n)
// Space Complexity : O(m+n) -- not sure 
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : Didn't try using Binary search method tried 
using linesr search. Could be done using binary search. Not sure how but this
solution got accepted on leetcode.
*/

/* Approach followed -- 
Compare the target element with the first and last element of each row.
If equal then return true else see between which first and last element 
does the target lie.
Get that row index and then traverse the column at that row to check if the element is 
present or not
 * 
 */


// Your code here along with comments explaining your approach in three sentences only



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int findRow = -1;
        for(int i=0;i<rowLen;i++){
            if(target==matrix[i][0] || target==matrix[i][colLen-1]) return true;
            if(target>matrix[i][0] && target<matrix[i][colLen-1]){
                findRow = i;
                break;
            }
        }
        if(findRow==-1) return false;
        for(int j=0;j<colLen;j++){
            if(target==matrix[findRow][j]) return true;
        }

        return false;
    }
}