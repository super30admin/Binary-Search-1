class search2d{
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int low = 0;
        int high = row*column-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(matrix[mid/column][mid%column]==target){
                return true;
            }else if(matrix[mid/column][mid%column]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        search2d s = new search2d();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 10;
        s.searchMatrix(matrix,target);
    }
}