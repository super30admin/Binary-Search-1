// Time Complexity :O(log(MN))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//We are going to search the target in 2D matrix by binary search approach
//Behing the hood/jvm,m*n matrix is stored as array list or 1D aray ,with first index reference to memory
//For Binary search on array we need low,high and mid
    //low is the first index
    // high is the last index .How do we find it ?
        // for that we need m(no of rows), n (no of columns) .so formula to find m(row) = matrix.length; formula to find n(column) = matrix[0].length
    // mid index = low+(high-low)/2
//Now how do we find the value of the corresponding mid index
//JVM calculate the index for corresponding rowcolumn by  formula index = row*n+column.
//Our challenge is to find the corresponding row column for the index
    //Row calculation = mid index /noOfColumns (Example: 5/4 =1)
    //COlumn Calculation = mid index % noOfColumns (Example: 5%4=1)
//From above we derived the mid index position as [1][1]

//Summary
//assuming Flattening the matrix to list and find the mid index
// then do binary search



class BinarySearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //m*n matrix is stored as a array list in the backgroundby jvm
        if(matrix == null || matrix.length == 0)
            return false;

        //initilazing the matrix
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m*n-1;
        while(low <= high) {
            //Calculating the mid index
            int mid = low + (high - low)/2;
            //calculating corresponding row & column of mid index
            int row = mid/n;
            int column = mid%n;

            if(matrix[row][column] == target)
                return true;

            else if(matrix[row][column] > target)
                high = mid-1;
            else
                low = mid -1;

        }
        return false;
}

