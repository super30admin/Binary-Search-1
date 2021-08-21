class Search2DMatrixSolution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int lo = 0;
        int hi = row;
        while(lo <= hi){
            int mid  = lo + (hi-lo)/2;
            if(mid == row){
                if(target <= matrix[mid][col] && target>=matrix[mid][0]){
                    return binarySearch(matrix[mid], target);
                }
                else if(target<matrix[mid][0]){
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }
            }
            else{
                if(target < matrix[mid+1][0] && target>=matrix[mid][0]){
                    return binarySearch(matrix[mid], target);
                }
                else if(target<matrix[mid][0]){
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }
            }
        }
        return false;
    }
    public boolean binarySearch(int[] arr, int target){
        int lo = 0;
        int hi = arr.length-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] == target){
                return true;
            }
            if(arr[mid] > target){
                hi = mid-1;
            }
            else{
                lo = mid + 1;
            }
        }
        return false;

    }
}