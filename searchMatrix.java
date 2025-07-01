class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int r = mid/n;
            int c = mid % n;
            if (matrix[r][c] == target){
                return true;
            }
            else if(matrix[r][c] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }

}


class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[low] <= nums[mid]){ //left part sorted
                if(nums[low] <= target && nums[mid] >= target){
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else{
                if(nums[mid] <= target && nums[high] >= target){ //right sorted
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

}

class Solution {

    public int search(ArrayReader reader, int target) {

        int low = 0; int high = 1;

        while(reader.get(high) < target){

            low = high;

            high = 2 * high;

        }

        return binarySearch(reader, target, low, high);

    }

    private int binarySearch(ArrayReader reader, int target, int low, int high){

        while(low <= high){

            int mid = low + (high - low)/2;

            if(reader.get(mid) == target){

                return mid;

            } else if (reader.get(mid) > target){

                high = mid - 1;

            } else {

                low = mid + 1;

            }

        }

        return -1;

    }

}