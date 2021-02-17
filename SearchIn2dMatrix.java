// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
		// Calculate number of rows and columns
        int rows = matrix.length;
        int columns = matrix[0].length;
        
		// Initializing pointers left to 0 and right to number of elements - 1
        int l = 0, r = rows * columns - 1;
        
		// Terminating condition l <= r
        while(l <= r){
			// calculating mid value
            int mid = l + (r-l)/2;
			
			// finding row and column by dividing and modulus by columns 
            int row = mid / columns;
            int column = mid % columns;
            
			// if value is equal to target, return true
            if(matrix[row][column] == target){
                return true;
            }else if(matrix[row][column] > target){
                r = mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;
    }
}

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int rows = matrix.length;
//         int columns = matrix[0].length;
        
//         int rowNo = -1;
            
//         for(int i=0; i<rows; i++){
//             if(matrix[i][0] <= target && matrix[i][columns-1] >= target){
//                 rowNo = i;
//                 break;
//             }
//         }
        
//         if(rowNo == -1){
//             return false;
//         }
        
//         System.out.println(rowNo);
        
//         int l=0, r=columns-1;
        
//         while(l<=r){
//             int mid = l + (r-l)/2;
            
//             if(matrix[rowNo][mid] == target){
//                 return true;
//             }
//             else if(matrix[rowNo][mid] > target){
//                 r = mid-1;
//             }else{
//                 l = mid+1;
//             }
//         }
        
//         return false;
        
//     }
// }