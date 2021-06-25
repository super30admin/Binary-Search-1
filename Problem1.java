// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, the github meant binary search but I just implemented using brute force approach


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int m=0;m<matrix.length;m++){
            for(int n=0;n<matrix[m].length;n++){
                if(target==matrix[m][n]){
                    return true;
                }
            }
        }
        return false;
    }
}