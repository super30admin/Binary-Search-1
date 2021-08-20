public class Problem1
{
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        int width = matrix[0].length;
        for(int i = 0; i < length; i++)
        {
            for(int j = 0; j < width; j++)
            {
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}