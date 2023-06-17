class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0 , j = n-1;

        while(i < m && j >=0) {

            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target) 
                j--;
            else
                i++;
        }

        return false;
        
    }

    public static void main(String[] args) {
        
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        int target = 3;
        boolean result = searchMatrix(matrix , target);
        System.out.println(result);
    }
}