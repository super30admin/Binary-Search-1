//n-->row and m-->col
//Time complexity=log(m*n){for each row logn and for each col logm as in both row and column we are applying binary as we are diving the search space in half}
//in this algo I an virtually considering the 2d matrix as single matrix and then we are applying the binary search from 0 to n*m-1.
//Imprtant thing here is method of getting row and col after calculating mid that is / and % by numbe of column as number of column decide the rows and then after //calculating row and col we are feacthing the required element and comparing with our target.
//rest is same binary logic.
//Got executed on leetcode-->yes
​
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int high=(matrix.length*matrix[0].length)-1;
        
        if(matrix.length==0 || matrix[0].length==0){
            return false;
        }else{
            while(low<=high){
                int mid=low+(high-low)/2;
                int row=mid/matrix[0].length;//I need to remember this mehtod
                int col=mid%matrix[0].length;//I need to remember this mehtod
                
                if(matrix[row][col]==target){
                    return true;
                }else if(matrix[row][col]<target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            
            }
            return false;
        }
    }
}
