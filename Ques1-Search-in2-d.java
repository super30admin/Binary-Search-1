// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
// Line 22 has to be <=. I was initially trying it with 
// while(low<high). Then realized that mid could be at the exact mid when both low and high are
// pointing to it.


// Your code here along with comments explaining your approach
// Pretty straight forward approach.
// Search for the row where the element could be present by applying,
// Binary Search on the first column of the matrix.
// Then in that particular row find the element using another Binary Search
// By fixing the row number of the matrix.

class Solution {
    
    public int getRow(int[][]matrix,int target){
        int len = matrix.length;
        int low = 0;
        int high = len-1;
        int ans=-1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(matrix[mid][0]<target){
                ans=mid;
                low = mid+1;
            }
            else if(matrix[mid][0]>target){
                high = mid-1;
            }
            else{
                return mid;
            }
        }
        return ans;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = getRow(matrix,target);
        //System.out.println("ROWINDEX "+rowIndex);
        if(rowIndex ==-1){
            return false;
        }
        int len = matrix[0].length;
        int low = 0;
        int high = len-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            //System.out.println("MID "+mid);
            if(matrix[rowIndex][mid]<target){
                low = mid+1;
            }
            else if(matrix[rowIndex][mid]>target){
                high = mid-1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}