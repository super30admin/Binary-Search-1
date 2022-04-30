// s30 Problem #5 - medium
// Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
// Time Complexity : (log m + log n) m rows, n columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Approach: 
// use Binary Search on column-side to check for the mid row
// Then if the target is within range of the row apply Binary Search to find the element
/**
 *  L
 *  |
 *  |        M
 * M|L<------------->H   <==check range and apply BS on row
 *  |               
 *  |
 *  H
 */
class Problem5 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // use BS on column to check for the mid row
        int cLow = 0;
        int cHigh = matrix.length - 1;
        
        
        while(cLow <= cHigh){
            int cMid = cLow + (cHigh - cLow)/2;
            // System.out.println("column:" + cLow + " " + cMid + " " + cHigh);
            int end = matrix[cMid].length-1;

            if(matrix[cMid][0] <= target && target <=matrix[cMid][end]){
                // do BS for this row
                // System.out.println("here:" + matrix[cMid][end]);
                int rLow = 0;
                int rHigh = end;
                while(rLow <= rHigh){
                    int rMid = rLow + (rHigh - rLow)/2;

                    if (matrix[cMid][rMid] == target) {
                        return true;
                    } else if (matrix[cMid][rMid] < target){
                        rLow = rMid + 1;
                    } else {
                        rHigh = rMid - 1;
                    }
                }
                return false;
            } else {
                if (matrix[cMid][end] <= target) {
                    cLow = cMid + 1;
                }
                else {
                    cHigh = cMid - 1;
                }
            }
        }
        return false;
    }
}
public class Problem0 {
    public static void main(String[] args) {
        int[][] matrix = {
		    {1,3,5,6,8},
		    {9,11,14,18,21},
		    {25,27,28,30,32},
            {34,36,39,41,47},
            {49,53,59,61,71},
        };
        int target = 41;
        
        Problem5 p = new Problem5();
        boolean result = p.searchMatrix(matrix, target);
        System.out.println(result);
    }
}
