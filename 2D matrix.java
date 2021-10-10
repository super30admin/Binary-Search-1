// Time Complexity :m+log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int start=0;
        int end=rows-1;
        int mid=0;
        int targetRow=0;
        while(start<=end){
            if(matrix[start][cols-1]>=target){
                targetRow=start;
                break;
            }else{
                start++;
            }   
        }
        
        start=0;
        end=cols-1;
        
        while(start<=end){
             mid=(start+end)/2;
            if(target==matrix[targetRow][mid]) return true;
            if(target<matrix[targetRow][mid]) end=mid-1;
            else start=mid+1;
        }
        
        return false;
    }
}