// time complexity - O(logmn)
// space complexity - O(1)
//  I have got solution by this method  BUT    MY second solution DIDN'T work when I used (logn+logm) method
// Could you please let me know the mistake. I am getting time exceeded. 
// I have mention my second code below 1st solution. Please review it 


// Solution -I 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m=matrix.length;
        int n=matrix[0].length;
        if(m==0){
            return false;
        }
        int start=0;
        int end= m*n-1;
        int mid;
        int mid_element;
        while(start<=end){
            mid=start +(end-start)/2;
            mid_element= matrix[mid/n][mid%n];
            if(target==mid_element){
                return true;
            }else if( mid_element < target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
        
    }
}
// 2nd Solution

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int row=matrix.length;
//         int col=matrix[0].length;
        
//         int row_start=0;
//         int row_end=row-1;
//         int mid_row;
//         int mid_col; int col_start=0;int col_end=col-1;
        
//         if(row==0 || col==0){
//             return false;
//         }
    
//         while(row_start<=row_end){
//             mid_row=row_start+(row_end-row_start)/2;
            
//             if(matrix[mid_row][col-1]>=target){
               
//                 if(matrix[mid_row][0]<=target){
//                     mid_col= col_start + (col_end-col_start)/2;
//                     if(matrix[mid_row][mid_col]==target){
//                         return true;
//                     }
//                     if(matrix[mid_row][mid_col]>target){
//                         col_end=mid_col-1;
//                     }else{
//                         col_start=mid_col+1;
//                     }
//                 }else{
//                     row_end=mid_row-1;
//                 }
//             }else{
//                 row_start=mid_row+1;
//             }
//         }
//         return false;
//     }
// }