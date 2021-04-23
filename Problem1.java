
//Problem1: Search a 2D Matrix

// Time Complexity : O(log mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       if(matrix.length==0)
            return false;
        int rows= matrix.length;
        int columns= matrix[0].length;

        int left=0;
        int right=rows*columns-1;

    while(left<=right){
        int midpoint=left+(right-left)/2;
        int mid_element=matrix[midpoint/columns][midpoint%columns];

        if(target==mid_element)
            return true;
        if(mid_element > target)
            right=midpoint-1;
        if(mid_element < target) 
            left=midpoint+1;
        }
	return false;
 }
}