// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//considered imaginarily end as rows*column element in which it will be multiplied value /c and %c
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0;
        int end = row * column - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(matrix[mid/column][mid%column] == target)
                return true;
            if(matrix[mid/column][mid%column] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return false;
    }
}