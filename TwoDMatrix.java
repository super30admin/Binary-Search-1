//Time Complexity: O(log (mn))
//Space Complexity: O(1)
//Run successfully on LeetCode: Yes

public class TwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length == 0 || matrix == null)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0; 
        int high = m*n - 1;
        
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            int row = mid/n;
            int col= mid%n;
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] > target)
            {
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        
        return false;
    }    

    public static void main(String[] args)
    {
        TwoDMatrix td = new TwoDMatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(td.searchMatrix(matrix, 3)); 
        System.out.println(td.searchMatrix(matrix, 70)); 
    }
}
