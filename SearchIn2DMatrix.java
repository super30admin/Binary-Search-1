class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int start=0, end=m*n-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            int rowIdxMid = mid/n;
            int colIdxMid = mid%n;
            if(matrix[rowIdxMid][colIdxMid] == target) return true;
            else if(matrix[rowIdxMid][colIdxMid]>target){
                end = mid-1;
            } else{
                start = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchIn2DMatrix obj = new SearchIn2DMatrix();
        int[][] nums = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 80;
        boolean res = obj.searchMatrix(nums, target);
        System.out.println("result = " + res);
    }
}