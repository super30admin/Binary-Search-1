//Time Complexity :O(m +log n)
//Space Complexity :O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : This code takes lot of time, I have commented another code below i.e Log(m*n)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int  i = -1;  
        for(int j=0;j<m;j++){
            if(matrix[j][n-1]>=target){
                i=j;
                break;
            }
        }
        if(i==-1) return false;

        int low = 0,high = n-1; 
        int mid;
        while(low <= high){
            mid = low + (high-low)/2;
            if(matrix[i][mid] == target){
                return true;
            }
            else if(matrix[i][mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
        
    }
}
//Time Complexity :O(log m*n)
//Space Complexity :O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : Assuming matrix as a Straight Array
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int m= matrix.length;
//         int n= matrix[0].length;

//         int low=0,high=m*n-1;  // fisrt element [0][0] , last [m-1][n-1]
         
//         while(low<= high){
//             int mid= low+ (high -low)/2;
//             int row = mid/n; // retriving the mid element in array
//             int col = mid%n;
//             if(matrix[row][col]==target){
//                 return true;
//             }
//             else if(matrix[row][col]>target){
//                 high = mid - 1;
//             }
//             else{
//                 low = mid + 1;
//             }
                
//         }
//         return false;

//     }
// }

