//  Problem1 
// Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
// time complexity: O(logn)
// Leet code solution accepted in java 100% faster runtime then online submissions


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length ==0) return false;    //check for empty matrix
        //initializing row and columns based on the matrix
        int rows = matrix.length;
        int columns = matrix[0].length;
        //since this is a matrix we need to focus on the right part since it is 2-d in nature
        int left = 0;
        int right = rows*columns-1;
        //parse through the matrix 
        while(left<=right){
            //calculate midpoint and the element in the 2d matrix 
            //note midpoint can also be written as left+right//2
            int midpoint = left+(right-left)/2;
            int midpointelement = matrix[midpoint/columns][midpoint%columns];
            //following the same flow as a normal binary search algorithm
            if(midpointelement==target){
                return true;
            }else if(target<midpointelement){
                right = midpoint-1;
            }else if(target>midpointelement){
                left = midpoint +1;
            }
            
        }
        return false;
    }
}