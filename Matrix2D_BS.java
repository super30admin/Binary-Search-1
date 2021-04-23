// Time Complexity : O(log(mn))
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach



class Matrix2D_BS {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0)
            return false; // base case
        int m= matrix.length;
        int n=matrix[0].length;
        int high=n*m-1;
        int low=0;
        while(low<=high){
            int mid =low+(high-low)/2;
            int row=mid/n;
            int column=mid%n;
            if(matrix[row][column]==target)
                return true;
            else{
                if(matrix[row][column]<target){
                    low=mid+1;
                }
                else
                    high=mid-1;
            }
            
        }      
        
        return false;
    }

    public static void main(String args[]) 
    {
        Matrix2D_BS obj = new Matrix2D_BS();
        int array_input[][]={ { 1, 2, 3}, { 4 ,5,6},{ 7 ,8,9}  };
        if(obj.searchMatrix(array_input, 10))
            System.out.println("Element is present ");
        else
            System.out.println("Element is not present");

        
    
    }




}