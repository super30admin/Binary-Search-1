// Time Complexity : O(log(n*m))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only

//Question: 33. Search in Rotated Sorted Array

//Binary seacrh but the catch is array is not sorted, find the mid, since nums is possibly rotated at an unknown pivot index k, you will notice that
// from the mid either left or right side or array will already be sorted


class SearchIn2DMatrix {
    /*
        * linear search two loops and search for element - TC O(m*n) Space O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }

        int rows = matrix.length;  //total no of rows
        int cols = matrix[0].length; //total no of columns
        int low = 0;
        int high = rows*cols -1;
        while(low <= high){

            int mid = low + (high - low)/2; //why doing this - to prevent integer overflow
            int row = mid/cols; 
            int col = mid%cols;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return false;
    }
}

// Driver code 
class Main { 
    public static void main(String args[]) 
    { 
        SearchIn2DMatrix search = new SearchIn2DMatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 0;
        boolean result = search.searchMatrix(matrix, target);
        System.out.println(result);
    } 
}