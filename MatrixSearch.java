class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
     for (int[] arr : matrix){
         int lastIndex = arr.length - 1;
         if (arr[lastIndex] > target) {
            return binarySearch(arr, target);
         }
     }  
        return false;
    }
    
    public boolean binarySearch(int[] matrix, int target) {
        int low = 0;
        int high = matrix.length -1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if(matrix[mid] == target){
                return true;
            } else if (matrix[mid] > target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}