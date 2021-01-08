class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0)
            return false;
        if( matrix[0] == null ||  matrix[0].length == 0)
            return false;

        int horizontalLength = matrix[0].length;

        for(int i=0; i < matrix.length; i++){
            if(target >= matrix[i][0] && target <= matrix[i][horizontalLength-1])
                return binarySearch(matrix[i], 0, horizontalLength-1, target);
        }

        return false;
    }

    public boolean binarySearch(int[] arr, int l, int r, int target){

        if(r >= l){
            int mid = l + (r - l)/2;
            if(target == arr[mid])
                return true;
            if(target > arr[mid]){
                return binarySearch(arr, mid+1, r, target);
            }else
                return binarySearch(arr, l, mid-1, target);
        }
        else{
            return false;
        }
    }
}