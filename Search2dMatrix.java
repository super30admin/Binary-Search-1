// Time Complexity : O(log(m*n)) because we're dividing a m*n sized list into halves each time until we get a solution
// Space Complexity : O(1), no auxiliary data storage needed
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class Search2dMatrix
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        boolean present = false;
        int numberOfRows = matrix.length;
        if(numberOfRows < 1)
        {
            return false;
        }

        int numberOfColumns = matrix[0].length;
        int totalNumberOfElements = numberOfRows * numberOfColumns;
        int low = 0;
        int high = totalNumberOfElements -1;

        int result = binarySearch(low, high, target, matrix, numberOfRows, numberOfColumns);
        if(result != -1)
        {
            present = true;
        }
        return present;
    }

    public int binarySearch(int low, int high, int target, int[][] matrix, int numberOfRows, int numberOfColumns)
    {
        int mid =  -1;
        int index = -1;
        if(matrix.length == 0 || low < 0 || high < 0)
        {
            return index;
        }

        while(high >= low)
        {
            mid = (low + high)/2;
            int rowNumber = mid / numberOfColumns;
            int columnNumber = mid % numberOfColumns;

            if(matrix[rowNumber][columnNumber] == target)
            {
                return mid;
            }
            else if(target > matrix[rowNumber][columnNumber])
            {
                //search the right half
                low = mid +1;
            }
            else
            {
                high = mid -1;
            }
        }
        return index;
    }
    public static void main(String[] args)
    {
        Search2dMatrix s = new Search2dMatrix();
        int[][] arr = new int[2][1];
        arr[0][0] = 1;
        arr[1][0] = 3;

        System.out.println(s.searchMatrix(arr, 3));
    }
}