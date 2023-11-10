// Time Complexity : O(log(m*n))
// Space Complexity : Auxiliary space complexity is O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -


// LC 74 : Search a 2D Matrix - Need to search for an element in m*n matrix
//Visualize the 2D matrix as a linear array structure, and do binary search by calculating mid and eliminating halves
class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length; //no. of rows
        int n = matrix[0].length; // no. of columns

        //Indexes of values so high should be length -1
        int low = 0, high = m*n -1, mid;

        //Traverse until low and high come together. <= is needed to check the
        while(low <= high) {
        mid = low + (high - low)/2;

        int row = mid / n;
        int col = mid % n;

        if(target == matrix[row][col]) return true;
        else if(target < matrix[row][col]) {
            high = mid - 1;
        }
        else
            low = mid + 1;

        }

        return false;

    }


            //Alternate approach: Simple algorithm using Java predefined DS, with minimal code
            //Set<Integer> set = new HashSet();
            //set.addAll(Arrays.toList(matrix));
            //System.out.println(set);
}