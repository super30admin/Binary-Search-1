// TC: O(logMN) where M is row size and N is column size
// SC: O(M*N)

class SearchSortedMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target) 
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return false;
    }

    public static void main(String args[]) {
        SearchSortedMatrix sm = new SearchSortedMatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println("Element 16 present: "+sm.searchMatrix(matrix,16));
        System.out.println("Element 13 present: "+sm.searchMatrix(matrix,13));
    }
}

/**
Output:

Element 16 present: true
Element 13 present: false
 */