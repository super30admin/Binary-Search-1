class Matrix {
    public boolean searchMatrix(int[][] mat, int k) {
        int m =mat.length;
        int n=mat[0].length;
        int l = 0, r = m - 1;
        while (l <= r)
        {
            int mid = l + (r - l) / 2;

            if (k >= mat[mid][0] && k <= mat[mid][n - 1])
                return searchRow(mat[mid], n, k);

            if (k < mat[mid][0])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
    boolean searchRow(int M[], int n, int k)
    {
        int l = 0, r = n - 1;
        while (l <= r)
        {
            int mid = l + (r - l) / 2;

            if (M[mid] == k)
                return true;

            if (k < M[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }

}