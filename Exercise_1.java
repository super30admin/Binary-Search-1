// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        /** intitializee the length of the matrix*/
        int m = matrix.length;

        if (m == 0) {

            return false;

        }

        /** Initialize n length*/
        int n = matrix[0].length;

        /** binary search starts*/

        /** initializing left and right by 0 and n*m-1*/
        int left = 0, right = n * m - 1;


        /** checking condition left should be always <= right */
        while (left <= right) {


            int pivotIndex = (left + right) / 2;

            /** checking the pivot element*/
            int pivotElement = matrix[pivotIndex / n][pivotIndex % n];

            /** checking the target value with pivot element value */
            if (target == pivotElement) {

                return true;

            } else {

                /** if the target is less then explore left side else right side */
                if (target <= pivotElement) {

                    right = pivotIndex - 1;
                } else {

                    left = pivotIndex + 1;
                }

            }


        }

        return false;
    }
}

