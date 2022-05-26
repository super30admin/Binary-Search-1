//Time Complexity: O(log(mn))
// Space Complexity: O(1)

// Did the code run on leetcode: Yes


class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Get the number of rows
        int rows = matrix.length;
        //Get the number of Coloumns
        int coloumns = matrix[0].length;

        int left = 0;
        int right = rows * coloumns - 1;
        // Solving this problem by considering the matrix to be a single array. Hence once the midPoint is found, we need to convert that into a index in the matrix
        while(left <= right){
            // Get the midpoint
            int midPoint = (left + right)/2;
            // Get the midElement
            int midElement = matrix[midPoint / coloumns][midPoint % coloumns];
            if(midElement == target)
                return true;
            // The target lies on the right side of the matrix
            else if(midElement > target)
                right = midPoint - 1;
            // The target lies on the left side of the matrix
            else left = midPoint + 1;
        }

        return false;
    }
}