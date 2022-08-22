class searchMatrix {
    public static boolean sM(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0) return false;

        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = m*n-1;

        while(low<=high) {
            int mid = low + (high-low)/2;
            int r = mid/m;
            int c = mid%m;

            if(matrix[r][c] == target) return true;
            else if (matrix[r][c] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
        
    }
    public static void main(String[] args) {

        int matrix [][] = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 3;
        System.out.println(sM(matrix, target));

    }
}
