// Problem 1: Seach a 2D Matrix

// Approach 1 :Brute force approach
// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// Used brute force approach, iterating with all the matrix elements and 
// searching the element one by one in a matrix till it matches the target value
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        //edge case
        if(matrix.length == 0 || matrix == null)
            return false;
        //Iterating with all the elements in a matrix 
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                //checking if the matrix value is equal to the target
                if(matrix[i][j]==target)
                {
                    return true;
                }
            }
        }
        return false;
    }
}

// Approach 2 : Optimized approach
// Time Complexity : O(log (mn)) because the search time is reduced every half
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// Used binary search algorithm for searching target element
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    
    //checking if matrix is empty
    if(matrix.length==0)
        return false;

    
    int rows= matrix.length;
    int columns= matrix[0].length;

    int low=0;
    int high=rows*columns-1;

    while(low<=high)
    {
        int midpoint=low+(high-low)/2;;
        int mid_element=matrix[midpoint/columns][midpoint%columns];

        if(target == mid_element)
            return true;
        if(mid_element > target)
            high=midpoint-1;
        if(mid_element < target) 
            low=midpoint+1;
    }
    return false;
    }
}