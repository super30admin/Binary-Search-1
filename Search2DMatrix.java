// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
public class Search2DMatrix {

    static int index1, index2, n, m;

    public void setIndex(int mid) {

        index1 = (mid / m);
        index2 = (mid % m);

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        index1 = -1;
        index2 = -1;
        n = matrix.length;
        m = matrix[0].length;
        int low = 0;
        int high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            setIndex(mid);
            if (matrix[index1][index2] == target)
                return true;
            else if (matrix[index1][index2] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;

    }

}
