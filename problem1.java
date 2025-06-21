// Time Complexity: O(log n)
// Space Complexity: O(1)

// First find the row where elem could lie, by narrowing search across columns
// Then apply a simple binary search in targeted row

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int cols = matrix[0].length-1;

        int targetRow = getTargetRow(matrix, target); // narrow the search space to 1 row

        if (targetRow<0) return false;

        int l = 0, r = cols;


        // apply a regular binary search on the target row
        while (l<=r) {

            int mid = l + (r-l)/2;

            if(target>matrix[targetRow][mid])
                l = mid+1;
            else if (target<matrix[targetRow][mid])
                r = mid-1;
            else
                return true;

        }

        return false;

    }

    public int getTargetRow(int[][] matrix, int target) {

        int rows = matrix.length-1;
        int cols = matrix[0].length-1;

        int l = 0, r = rows;

        while(l>=0 && r>=0 && l<=r) {

            int mid = l + (r-l)/2;
            // we have narrowed down the search space to the correct row
            if (l==r)
                return l;

            // target value exists in a row lower than mid
            if (target > matrix[mid][cols])
                l = mid+1;

                // target value exists in a row same as mid or lower
            else if (target <= matrix[mid][cols])
                r = mid;



        }

        // target value is larger than our largest value in 2d matrix
        return -1;

    }
}