// Time Complexity : O(m logn)
// Space Complexity : O(m logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            int l = matrix[i].length-1;
            if(matrix[i][l] >= target){
                // target 16 -> i[i.length - 1] is 20 and 20>16
                return binSearch(matrix[i], target);
            }
        }
        return false;
    }
    public boolean binSearch(int[] arr, int target){
        int l=0; int r=arr.length-1; int mid;
        while(l<=r){
            mid = l + (r-l)/2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }
}