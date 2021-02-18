// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Followed the approach where we make the code behave as if it is working on a 1-d array and not a 2-d array
//we check the mid , if element is at mid we return true , if element is less than mid then we disregard the right portion by changing the 'r' pointer
//if the element is greater than mid then we diregard the left portion by the'l' pointer
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int l = 0;
        int r = (n*m)-1;
        
        while(l <= r)
        {
            int mid = l + (r-l)/2;
            
            int i = mid/m;
            int j = mid%m;
            
            if(matrix[i][j]==target)
            return true;
            else if(target<matrix[i][j])
                r = mid - 1;
            else
                l = mid + 1;
            
        }
        return false;
    }
}