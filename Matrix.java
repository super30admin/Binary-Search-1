// Time Complexity : O(lognm) where m is the row number and n is the column number
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Search 2D Matrix

class Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
       int m = matrix.length -1;
       int n = matrix[0].length -1;
        System.out.println("n" + n);
        int i=0;
       while(i<=m){
           if (target<=matrix[i][n]) break;  //checking which row the target could be at
               i++;
       }
        int low = i; //matrix[i][0];
        int high = n; //matrix[i][n];
        System.out.println("low " + low);
        System.out.println("high " + high);
        System.out.println("During in while loop: ");
        if( low == 1 && n == 0 && target == matrix[0][0]) return true; 
        while(low<=high){ //doing binary search in that row we got from the previous iteration 
            int mid = low + (high-low)/2;
            System.out.println("mid " + mid);
            System.out.println("low " + low);
            System.out.println("high " + high);
            if(target == matrix[i][mid]) return true;
            else if(target>=matrix[i][low] && target<matrix[i][mid]) high = mid-1;
            else low = mid+1;
            //else if(target>matrix[i][mid]) low = mid+1;
            //else if(target<matrix[i][mid]) high = mid-1;
        }
        return false;
    }
}