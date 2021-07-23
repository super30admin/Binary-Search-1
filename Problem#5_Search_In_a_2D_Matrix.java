// Time Complexity : O(log(mn)) for standard binary search tree. Here m*n defines the actual length(in linear array terms).
// Space Complexity : O(1) i.e. constant as we are only using variable for index values and element value.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      /*
       * Space complexity: O(1) i.e. constant as we are only using variable for index values and element value.
       * Time complexity: O(log(mn)) for standard binary search tree. Here m*n defines the actual length(in linear array terms).
       * */
      // Solution Binary search using a pivot element
      int r = matrix.length;
      if(r==0) return false;
      int c = matrix[0].length;
     
      //BST select/find out the pivot/mid index
      int left = 0;
      int right = r*c-1; //Total elements if linear array considered
      int pivot, pivotVal;
      while(left<=right){
         pivot = (left+right)/2;
         pivotVal = matrix[pivot/c][pivot%c];
          if(pivotVal==target) return true;
          else{
              if(target>pivotVal){
            	  left = pivot + 1;
              }
             } else{
                 right = pivot -1;
              }
         }
     }
     return false;
    	
//        //Solution - Bruteforce
//        if(matrix.length==0||matrix.length==0) return false;
//        int col1 = matrix[0].length-1;
//        int row1 = 0;
//        
//        while(row1<matrix.length && col1>=0)
//        {
//            if(matrix[row1][col1]>target) col1--;
//            else if(matrix[row1][col1]<target) row1++;
//            else return true;
//        }
//        return false;           
        
    }
}