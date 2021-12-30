public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0|matrix[0].length==0)
            return false;
        int row = 0;
        int col = matrix[0].length-1;
        while (row<matrix.length&&col>=0){
            if (matrix[row][col]==target)
                return true;
            else if (matrix[row][col]<target)
                col--;
            else
                row++;
        }
        return false;
    }

//    Input: nums = [4,5,6,7,0,1,2], target = 0
//    Output: 4
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            if (nums[mid]==target)
                return mid;
            else if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        while (reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
