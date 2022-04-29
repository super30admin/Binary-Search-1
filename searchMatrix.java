// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//imaginarily considered end as rows*column element in 2d array will be multiplied value/c and %c
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length;
        int c=matrix[0].length;
        int start=0;
        int end=r*c-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(matrix[mid/c][mid%c]==target)
                return true;
            if(matrix[mid/c][mid%c]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        return false;
        
    }
}