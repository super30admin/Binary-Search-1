class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        if (row == 0) return false;
        // int[] res = new int[row * col];
        // for (int i = 0; i < res.length; i++) {
        //     res[i] = matrix[];
        // }
        int left = 0, right = row * col - 1;
        int pivotIdx, pivotElt;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElt = matrix[pivotIdx / col][pivotIdx % col];
            if (target == pivotElt) return true;
            else {
                if (target < pivotElt) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }
}

// TC - O(log(mn))
// SC - O(1)