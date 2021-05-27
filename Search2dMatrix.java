class Search2dMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        System.out.println(n);
        int m = matrix[0].length;
        System.out.println(m);
        int col=m-1;
        int row =0;
        while(row<n && col >=0){
            if(matrix[row][col] == target){
                return true;
            }
             else if(matrix[row][col] > target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }

    public static void main (String[] args)
    {
        int x = 80;
        int mat[][] = {{0, 6, 8, 9, 11},
                       {20, 22, 28, 29, 31},
                       {36, 38, 50, 61, 63},
                       {64, 66, 100, 122, 128}};
     
        Boolean v= searchMatrix(mat, x);
        System.out.println(v);
         
    }
}