class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        if(matrix.length > 1)
            row = binarySearchRow(matrix, 0, matrix.length-1, target);


        return binarySearchColumn(matrix[row], 0, matrix[row].length-1, target);
    }

    public int binarySearchRow(int[][] nums, int left, int right, int target) {
        if(left > right) return left-1 > 0 ? left-1 : left;

        int mid = left + (right - left) / 2;
        if(nums[mid][nums[0].length-1] < target) {
            return binarySearchRow(nums, mid+1, right, target);
        }else if(nums[mid][0] > target) {
            return binarySearchRow(nums, left, mid-1, target);
        }else {
            return mid;
        }
    }

    public boolean binarySearchColumn(int[] nums, int left, int right, int target) {
        if(left > right) return false;

        int mid = left + (right - left) / 2;
        if(nums[mid] == target) {
            return true;
        }else if(nums[mid] > target) {
            return binarySearchColumn(nums, left, mid-1, target);
        }else {
            return binarySearchColumn(nums, mid+1, right, target);
        }
    }
}