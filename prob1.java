// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class prob1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0)
            return false;

        int low = 0;
        int high = (matrix.length*matrix[0].length)-1;
        while(low<=high){
            int mid = low - (low-high)/2;
            int rowNumber = mid/matrix[0].length;
            int columnNumber = mid%matrix[0].length;
            if(matrix[rowNumber][columnNumber]==target)
                return true;
            else if(matrix[rowNumber][columnNumber]<target)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;
    }
}
