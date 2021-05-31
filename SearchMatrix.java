// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowsCount = matrix.length;
        int colCount = matrix[0].length;
        int low = 0; 
        int high = (rowsCount * colCount) - 1; 
        int mid, middleElement;

        while (low <= high){
            mid = low + (high - low) / 2;

            middleElement = matrix[mid/colCount][mid%colCount];

            if (middleElement == target) return true;

            if(middleElement > target) 
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return false;

    }
}