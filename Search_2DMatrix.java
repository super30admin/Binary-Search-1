// Time Complexity : Worst Case (O(log N)), Best case (O(1))
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length == 0) return false; //checking if matrix exists, if no return false
        
        //to know length of 2D matrix i order to consider it as one D
        
        int rows = matrix.length; 
        int columns = matrix[0].length;
        
        //instantiating left and right indexes
        int left = 0;
        int right = rows*columns-1;
        
        
        while(left <= right){
            int midpoint = left +(right-left)/2; //calculate index of midpoint element
            int midpoint_element = matrix[midpoint / columns][midpoint % columns]; //calculating midpoint element
            //3 conditions to check if the target element is midpoint, > or < midpoint element
            if(target == midpoint_element){
            return true;
        } else if(target > midpoint_element) {
            left = midpoint+1; 
        }else if(target<midpoint_element){
            right = midpoint-1;
        }
     
        
    }return false;
} 
    
}

    