// Operation:              search
// Time Complexity:       O(log(mn))
// Space Complexity:        O(1)
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement in other approaches than optimal one

package src;

public class BinarySearch2DMatrix {
    public static void main(String[] args) {
        int[][] arr = { {1,3,5,7},{10,11,16,20},{23,30,34,60},{62,64,68,70},{71,73,74,76},{79,84,88,89},{91,92,93,97} };
//        int[][] arr = {{1,3}} ;
//        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}} ;
        int target = 92 ;

        Binary2DArray sol = new Binary2DArray() ;
        boolean b = sol.searchMatrix(arr, target) ;

        System.out.println(b) ;
    }
}


class Binary2DArray {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length ;
        int n = matrix[0].length ;
        int l = 0 ;
        int r = (m * n) - 1 ;

        while(l <= r)
        {
            int mid = l + (r-l)/2 ;
            int i = mid/n ;                                 // getting row count of mid element in entire 2D array
            int j = mid%n ;                                 // getting column count of mid element in entire 2D array

            if(matrix[i][j] == target)                      // mid element is target
                return true ;
            else if(matrix[i][j] > target)                  // mid element is greater than target
                r = mid-1 ;
            else                                            // mid element is less than target
                l = mid+1 ;
        }
        return false ;                                      // element not present
    }
}



// **************************************** Another Approach Using Recursion ****************************************
//class Binary2DArray {
//    public boolean searchMatrix(int[][] matrix, int target) {
//
//        int l = 0 ;
//        int r = (matrix.length * matrix[0].length) - 1 ;
//
//        return binarySearch(matrix, target, l, r) ;
//
//    }
//
//    private boolean binarySearch(int[][] matrix, int target, int beg, int end)
//    {
//        if(beg > end)
//            return false ;
//        else
//        {
//            int c = matrix[0].length ;
//            int mid = beg+(end-beg)/2 ;
//            int i = mid/c ;
//            int j = mid%c ;
//
//            if(matrix[i][j] == target)
//                return true ;
//            else if(matrix[i][j] > target)
//                return binarySearch(matrix, target, beg, mid-1) ;
//            else
//                return binarySearch(matrix, target, mid+1, end) ;
//        }
//    }
//}



// **************************************** Not so good Approach with two Binary Search ****************************************
//class Binary2DArray {
//    public boolean searchMatrix(int[][] matrix, int target) {
//
//        if(matrix[0][0] > target || matrix[matrix.length-1][matrix[0].length-1] < target)
//            return false ;
//
//        int begRow = 0 ;
//        int endRow = matrix.length - 1;
//
//        return binarySearchRow(matrix, target, begRow, endRow) ;
//
//    }
//
//    public boolean binarySearchRow(int[][] matrix, int target, int begR, int endR)
//    {
//        int col = 0 ;
//        int midRow = ( begR + endR ) / 2 ;
//
//        if(begR > endR)
//            return false ;
//        else if(begR == endR)
//        {
//            int begCol = 0 ;
//            int endCol = matrix[0].length - 1;
//            return binarySearchCol(matrix, target, begCol, endCol, midRow) ;
//        }
//        else
//        {
//            if(matrix[midRow][col] == target)
//                return true ;
//            else if(matrix[midRow][col] > target)
//                if(begR == midRow - 1)
//                {
//                    int begCol = 0 ;
//                    int endCol = matrix[0].length - 1;
//                    return binarySearchCol(matrix, target, begCol, endCol, midRow-1) ;
//                }
//                else
//                    return binarySearchRow(matrix, target, begR, midRow-1) ;
//            else
//            if(midRow+1 == endR)
//            {
//                int begCol = 0 ;
//                int endCol = matrix[0].length - 1;
//                if(matrix[midRow+1][col] > target)
//                    return binarySearchCol(matrix, target, begCol, endCol, midRow) ;
//                else
//                    return binarySearchCol(matrix, target, begCol, endCol, midRow+1) ;
//            }
//            else
//                return binarySearchRow(matrix, target, midRow, endR) ;
//        }
//    }
//
//    public boolean binarySearchCol(int[][] matrix, int target, int begC, int endC, int midRow)
//    {
//        if(begC > endC)
//            return false ;
//        else
//        {
//            int midCol = ( begC + endC ) / 2 ;
//            if(matrix[midRow][midCol] == target)
//                return true ;
//            else if(matrix[midRow][midCol] > target)
//                return binarySearchCol(matrix, target, begC, midCol-1, midRow) ;
//            else
//                return binarySearchCol(matrix, target, midCol+1, endC, midRow) ;
//        }
//    }
//}