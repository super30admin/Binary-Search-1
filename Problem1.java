// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Problem1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Iterate over the loop
        //Empty input array
        if(matrix.length==0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        //Consider 2D array as a long single array
        int size = row*col;
        int left = 0;
        int right = size-1;
        //Since it a sorted array we can use Binary Search approach to search the target element
        while(left<=right)
        {
            int mid = (left+right)/2;
            int row1 = mid/col;
            int col1 = mid%col;
            if(matrix[row1][col1]==target)
                return true;
            else if(matrix[row1][col1]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return false;
    }

}