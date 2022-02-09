// Time Complexity : O(logmn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Implemented using binary search
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int s = 0;
        int e = m*n - 1;
        int mid;
        
        while(s<=e){
            mid = s+(e-s)/2;
            int i = mid/n;      //Calculation to find out the indices where mid is present
            int j = mid%n;      
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] < target)
                s = mid + 1;
            else
                e = mid - 1;
}
        return false;
    }
}