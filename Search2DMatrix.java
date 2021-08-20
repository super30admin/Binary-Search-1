//Time complexity: O(log mn)
//Space complexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //length of the matrix
        int m = matrix.length;
        //if there are no elements in the matrix, return false
        if(m == 0) {
            return false;
        }
        int n =  matrix[0].length;
        int low = 0, high = (m*n) - 1;
        //use binary search to search the target element
        while(low <= high) {
            int mid = low + (high-low)/2;
            //We will find the element at the mid index of the matrix.
            int mid_element = matrix[mid / n][mid % n];
            if(mid_element == target) {
                return true;
            }
            //if the target greater than the element at mid, search on right sub tree
            if(target > mid_element) {
                low = mid + 1;
            }
            //else search on left sub tree
            else {
                high = mid - 1;
            }
        }
        return false;
    }
}