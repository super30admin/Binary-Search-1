// Time Complexity : O(Log(MN))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int low =0;
        int m=matrix.length;
        int n=matrix[0].length;
        int high = (m*n)-1;
        while(low<=high) {
            int mid = low+(high-low)/2;
            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
}

//Alternate Approach with O(log M+logN)
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int low =0;
        int high=matrix.length -1;
        int high2 = matrix[0].length -1;
        int rowToConsider = -1;
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(target >= matrix[mid][0] && target <= matrix[mid][high2]) {
                rowToConsider = mid;
                break;
            } else if(target <= matrix[mid][high2]) {
                high = mid -1;
            } else low = mid+1;
        }
        int low2 = 0;
        while(low2<=high2 && rowToConsider != -1) {
            int mid = low2+(high2-low2)/2;
            if(matrix[rowToConsider][mid] == target) return true;
            else if(matrix[rowToConsider][mid] > target) high2 = mid-1;
            else low2 = mid+1;
        }
        return false;
    }
}