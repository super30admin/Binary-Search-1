// Time Complexity : O(logm + logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

//Approach : As matrix is sorted. Perform binary search to find the row whose range can contain target. If no such row exists return false. else peform binary search on the row to find the target. If target is not found return false;
class Problem1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int top = 0;
        int bottom = matrix.length-1;
        int COL = matrix[0].length-1;
        while(top <= bottom){
            int mid = top +(bottom-top)/2;
            if(target < matrix[mid][0]){
                bottom = mid-1;
            }else if(target > matrix[mid][COL]){
                top = mid+1;
            }
            else{
                int left = 0;
                int right = COL;
                while(left <= right){
                    int middle = left +(right-left)/2;
                    if(matrix[mid][middle] == target){
                        return true;
                    }
                    if(target < matrix[mid][middle]){
                        right = middle-1;
                    }else{
                        left = middle+1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
