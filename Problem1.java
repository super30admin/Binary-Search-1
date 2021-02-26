class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0)
            return false;
        int n = matrix[0].length;
        
        int left=0, right = m*n-1;
        int pivotIdx, pivotElement;
        while(left <= right){
            pivotIdx = (left + right)/2;
            pivotElement = matrix[pivotIdx/n][pivotIdx%n];
            if(pivotElement == target)
                return true;
            else{
                if(target < pivotElement)
                    right = pivotIdx-1;
                else
                    left = pivotIdx+1;
            }
        }
        return false;
    }
}
//time - O(log(mn))
//space - O(1)