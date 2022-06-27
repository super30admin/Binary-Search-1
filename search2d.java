/**Time Complexity :
    O(log m*n)
// Space Complexity :
    O(1)
// Did this code successfully run on Leetcode :
    Yes
// Any problem you faced while coding this :   
    Faced a little problem with find method to understand the pointers
// Your code here along with comments explaining your approach
**/

class  search2d{
    public boolean searchMatrix(int[][] matrix, int target) {

        //for edge case
        if(matrix==null || matrix.length==0){
            return false;
        }

        //to get row and coulmn
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high=m*n-1;
        while(low<=high){

            //get middle element
            int mid=low+(high-low)/2;

            //to get row of the element
            int row=mid/n;

            //to get coulmn of the element
            int column=mid%n;

            //if target found return
            if(matrix[row][column]==target){
                return true;
            }

            //if target less, move to the left
            else if(target<matrix[row][column]){
                
                high=mid-1;
            }

            //if target larger move to the right
            else
            {
                low=mid+1;
            }
        }
        return false;
    }
}