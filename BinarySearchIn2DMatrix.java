class Solution {
    public boolean binarySearch(int[][] a, int t, int row, int l, int r) {
        int m;
        boolean ret = false;
        while(l <= r) {
            m = l + (r - l) / 2;
            if(a[row][m] == t) {
                ret = true;
                break;
            } else if (a[row][m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ret;
    }
    public boolean searchMatrix(int[][] a, int t) {
        int m, n, rowLow, rowHigh, midRow;
        boolean ret = false;
        m = a.length;
        n = a[0].length;
        rowLow = 0;
        rowHigh = m - 1;
        while(rowLow <= rowHigh) {
            midRow = (rowHigh + rowLow) / 2;
            if(t >= a[midRow][0] && t <= a[midRow][n-1]) {
                ret = binarySearch(a, t, midRow, 0, n-1);
                break;
            } else if (t <= a[midRow][0]) {     //move up towards first half
                rowHigh = midRow - 1;
            } else {                            //move down towards second half
                rowLow = midRow + 1;
            }
        }
        return ret;
    }
}