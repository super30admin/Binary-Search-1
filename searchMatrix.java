// Time Complexity :log (mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
public class searchMatrix{
    public boolean searchMatrix(int [][] matrix, int target){
        //Take null situation into consideration
        if(matrix==null || matrix.length==0) return false;
        //Initialization of lengths of m rows and n columns
        int m=matrix.length; int n=matrix[0].length;
        //for binary search we initialize low and high vars
        int low=0; int high=m*n-1;
        while(low<=high){

        int mid=low+(high - low)/2; // to keep mid inside the integer range
        int r=mid/n;   // for 1D array row index to find element
        int c=mid%n;    //for 1D array col index to find element
        if(matrix[r][c]==target){
            return true;
        }
        else if(matrix[r][c]>target){ //if target is smaller than mid element we will search in left half
            high=mid-1;
        }
        else{
            low=mid+1; //search in right upper half
         }
        

        }
    return false;
    }
}