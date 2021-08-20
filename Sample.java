// Time Complexity : O(mlogn)
// Space Complexity : o(mlogn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++){
            int n = matrix[i].length;
            if(matrix[i][0] <= target && target <= matrix[i][n-1]){
                return binarySearch(matrix[i],0,n-1,target);
            }
        }
        return false;

    }
    public boolean binarySearch(int[] nums, int l, int r, int target){

        if(r>=l){

        int mid = l + (r-l) /2;
        if (target == nums[mid]){
            return true;
        }
        if (target < nums[mid]){
                        return binarySearch(nums, l, mid-1, target);

        }
                    return binarySearch(nums, mid+1, r, target);

        }
        return false;

    }
}