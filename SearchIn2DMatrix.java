// Time Complexity : O(log mn)=O(log m)+O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/* m=row,n=column; 
 * method 1: burte force: travel all places n check; O(m*n)
 * method 2: finding range in row (linear search) and doing linear search in it column; O(m+n)
 * method 3: finding range in row (linear search) and doing Binary search in it column; O(m+ log n)
 * method 4: finding range in row (Binary search) and doing Binary search in it column; O(log m+ log n)
 * method 5: Binary search on each row then find/search in it; O(mlogn)
 * method 6: Binary search on each column thenk find in it; O(nlogm)
 * method 7: As row,column are stored we can makae a 1D array and perform Binary search by keeping track of low,high 
 * uisng size given array(m,n) and visa versa.
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int r = mid / n; // We need to find row, there are n colums.
            int c = mid % n;
            if(matrix[r][c]== target) return true;
            else if(matrix[r][c]>target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}
