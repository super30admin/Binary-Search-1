public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0)return false;
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0, high=m*n-1;
        while(low<=high)
        {
            int middle=low+(high-low)/2;
            int row=middle/n;
            int column=middle%n;
            if(matrix[row][column]==target)
                return true;
            else if(matrix[row][column]>target)
            {
                high=middle-1;
                
            }
            else low=middle+1;
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[][] matrix= {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix, 3));
    }
}
