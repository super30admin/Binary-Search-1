/*Time Complexity:- O(log(m*n))
  Space Complexity:- O(1)
  */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Base Case
        if(matrix==null || matrix.length==0)  {
            return false;
        }
        int m=matrix.length; //Rows
        int n=matrix[0].length; //Columns
        int low=0; //Set low
        int high=m*n-1; //Set High 
    
    //Loop until high is greater than low
    while(low<=high){
        int mid=low+(high-low)/2; //Find the middle element
        int row= mid/n; //Calculate row value
        int col=mid%n; // Calculate column value
        if(matrix[row][col]==target){ //Check if the value is equal to target                                
            return true; //If the value is same it is true
        }
        else if(target>matrix[row][col]){ //Check if the target is great than the value at that particular index
            low=mid+1; //then increament low=mid+1
        }
        else{
            high=mid-1; //If target is less than the value at that particular index then set high=mid-1 
        }
    }
    return false;//If we don't found that particular value than return false
 }
}
