// Time Complexity : O(log(rows+cols))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : searching finalRow I missed the target >matrix[rowMid][0] && target < matrix[rowMid+1][0] cond
// rowStart = rowMid; which made TLE

// Your code here along with comments explaining your approach in three sentences only
class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean isFound = false;
        int rowLen = matrix.length-1;
        int colLen = matrix[0].length-1;
        //search along col 0, if element found or the row that may contain the element
        int rowStart = 0;
        int rowEnd = rowLen;
        int finalRow = rowStart;
        //O(log rows)
        while(rowStart<=rowEnd)
        {
            int rowMid = rowStart + ((rowEnd-rowStart)/2);
            //return true if traget is found
            if(matrix[rowMid][0]==target)
            {
                return true;
            }
            //when searching row if reached end, that may be final row
            else if(rowMid==rowEnd)
            {
                finalRow = rowEnd;
                break;
            }
            //when search if target lies between current row and nextRow
            //prev cond will make sure we never get index out of bound for last row
            else if(target >matrix[rowMid][0] && target < matrix[rowMid+1][0])
            {
                finalRow = rowMid;
                break;
            }
            //adjust row to search
            else if(target>matrix[rowMid][0])
            {
                rowStart = rowMid + 1;
            }
            else
            {
                rowEnd = rowMid - 1;
            }
        }

        //once row is found search in the row using bnary search
        //O(cols)
        int colStart = 0;
        int colEnd = colLen;
        while(colStart<=colEnd)
        {
            int colMid = colStart + ((colEnd - colStart)/2);
            if(matrix[finalRow][colMid]==target)
            {
                return true;
            }
            else if(target > matrix[finalRow][colMid])
            {
                colStart = colMid + 1;
            }
            else
            {
                colEnd = colMid - 1;
            }
        }
        return isFound;

    }
}