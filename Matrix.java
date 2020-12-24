// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, did not know I had to / and use modulo operator to get the mid element.


// Your code here along with comments explaining your approach
public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0) return false;
    int m = matrix.length;
    int n = matrix[0].length;
    int low = 0;
    int high = m*n-1;
    
    while(low <= high){
        int mid = (low+high)/2;
        int midElement = matrix[mid/n][mid%n];
        if(midElement == target){
            return true;
        }else if (target < midElement){
            high = mid-1;
        }else{
            low = mid+1;
        }
    }
    return false;
}