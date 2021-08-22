public class searchMatrix
{

    public static void main(String[] arg)
    {

    }

    public boolean searchMatrix(int[][] matrix, int target)
    {
        int row = matrix.length;
        int col = matrix[0].length - 1;

        int l = 0;
        int r = row * col - 1;

        while (l <= r)
        {
            int m = l + (r - l) / 2;
            int rr = m / col;
            int cc = m % col;
            if (matrix[rr][cc] == target)
            {
                return true;
            }
            else if (matrix[rr][cc] < target)
            {
                l = m + 1;
            }
            else
            {
                r = m - 1;
            }

        }
        return false;
    }
}
