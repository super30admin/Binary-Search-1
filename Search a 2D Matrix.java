//Search a 2D Matrix

// Time Complexity : O(logm*logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        int start = 0;
        int end = rows-1;
        while(start<=end) {
            int mid = start+(end-start)/2;
            if(target <= matrix[mid][columns-1] && target>= matrix[mid][0]){
                int startr = 0;
                int endr = columns-1;
                while(startr<=endr) {
                    int midr = startr+(endr-startr)/2;
                    if(target == matrix[mid][midr]) {
                        return true;
                    }
                    if(target<matrix[mid][midr]) {
                        endr = midr-1;
                    }
                    else {
                        startr = midr+1;
                    }
                }
                return false;
            }
            if(target<matrix[mid][columns-1]) {
                end = mid-1;
            }
            else {
                start = start+1;
            }
        }
        return false;
    }
}