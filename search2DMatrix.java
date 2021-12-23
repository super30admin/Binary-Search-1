// Time Complexity : O(N + logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowLen = matrix[0].length;

        for(int row = 0; row < matrix.length; row++){

            if(target >= matrix[row][0] && target <= matrix[row][rowLen - 1]){
                return binarySearch(matrix[row], target);
            }
        }

        return false;

    }


    public boolean binarySearch(int[] arr, int key){

        int low = 0;
        int high = arr.length;
        int mid;

        while(low <= high){

            mid = low + (high - low)/2;

            if(arr[mid] == key){
                return true;
            }

            if(arr[mid] > key){
                high = mid - 1;
            }

            else{
                low = mid + 1;
            }

        }

        return false;
    }
}
