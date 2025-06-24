// Time Complexity : O(log(m*n)) m=rows, n=cols
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only
// I used binary search by pretending the 2D matrix is just one long list.  
// To find the actual row and column from the mid point, I used simple math (mid / columns for row, mid % columns for column).  
// I compared the target with the number at that position and kept adjusting the range until I found it or finished searching.


class searchMatrix{
    public boolean findTarget(int[][]matrix, int target){
        if(matrix.length==0 || matrix==null){
            return false;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int low = 0;
        int high = m*n-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col]==target){
                return true;
            }
            else if (matrix[row][col]>target){
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;

        
    }

    public static void main(String[]args){
        searchMatrix sm = new searchMatrix();
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}

        };
        int target = 30;
        System.out.println(sm.findTarget(matrix, target));




    }
}