// Time Complexity : O(log(m*n)) m*n is the total number of elements in the matrix
// Space Complexity : O(1) constant - because we didn't use any extra space
// Did this code successfully run on Leetcode : yes,
// Any problem you faced while coding this : code was fine but problem with editor. Refreshed the page and it ran successfully.


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false; // returning false is there are no elements in the matrix.

        int array_size = matrix.length* matrix[0].length; // length of virtual array
        int sub_arraySize = matrix[0].length;/// sub array size
        int low = 0; // declaring low
        int high = array_size - 1; // declaring high
        while(low <= high){ // implementing binary search
            int mid = low + (high - low)/2; // calculating mid element index
            int middle_Element = matrix[mid / sub_arraySize][mid % sub_arraySize];
            if(target == middle_Element){
                return true;
            } else if(target < middle_Element){
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }
        return false;
    }
}
