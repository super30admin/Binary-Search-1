/*
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
 */

//tc = O(log(mn))
//sc = O(1)

//thought process: we are imagining the 2D array into 1D array. This is because of the condition
//mentioned in the problem that last element of the row is smaller than first element in the next row.

class SearchIn2DMatrixJ{

    public boolean searchMatrix(int[][] matrix, int target){

        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;

        while(low <= high){
            //as the target is present in the problem, hence we can assume in the end, one single
            //element can also be an answer. So low <= high
            int mid = low + (high - low)/2;
            int r = mid/n, c = mid%n;
            if (matrix[r][c] == target){
                return true;
            }
            else if(matrix[r][c] > target){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }

        return false;

    }

}

/*
Leetcode analysis:
133 / 133 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 38.8 MB
 */