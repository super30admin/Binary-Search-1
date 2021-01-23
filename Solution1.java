// Search a 2D Matrix
// T:O(M*logN) //M is rows, N is column length
// S: O(1) //

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        for(int[] row : matrix){
            if(row[0]<=target && row[row.length-1]>=target){
                return binarySearch(row,target);
            }
        }

        return false;
    }

    public boolean binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(target==nums[mid])
                return true;
            else if(target<nums[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return false;
    }
}