public class TwoDMatrix {

        public static void main(String[] args) {
    
            int[][] mat = { { 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11 }, { 12, 13, 14, 15 } };
    
            int target = 5;
    
            TwoDMatrix result = new TwoDMatrix();
    
            boolean result1 = result.searchMatrix(mat, target);
    
            if (result1) {
                System.out.println("target found");
    
            } else {
                System.out.println("target not found");
            }
    
        }
    
        public boolean searchMatrix(int[][] matrix, int target) {
    
            if (matrix == null || matrix.length == 0)
                return false;
    
            int m = matrix.length;
            int n = matrix[0].length;
    
            int low = 0;
            int high = (m * n) - 1;
    
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int r = mid / n;
                int c = mid % n;
    
                if (matrix[r][c] == target)
                    return true;
    
                else if (matrix[r][c] > target) {
                    high = mid - 1;
    
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }
    
    }
    

