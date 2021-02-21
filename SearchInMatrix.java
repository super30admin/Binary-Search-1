// Time Complexity : O(log N) - We are not iterating all the elements. Treating a 2D array 1D then following binary search tree.
// Space Complexity : O(1) - We are just creating memory it doens't change much. I think its constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// Logic behind 2D to 1D array conversion assumption was difficult to understand.

// Your code here along with comments explaining your approach
public class SearchInMatrix {

    public boolean SearchInMatrix(int[][] matrix, int target) {

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        if(rowLength == 0) return false;

        int low = 0;
        int high = (rowLength * colLength) - 1;

        while(low <= high) {
            int midIndex = (low + high)/2;
            int midValue = matrix[midIndex/colLength][midIndex%colLength]; // 1*4 + 1 = 5 If we can divide 5/4 and 5%4 we can traverse to that mid element.

            if(midValue == target) {
                return true;
            }
            if(target<midValue) {
                high = midIndex -1;
            } else {
                low = midIndex+1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        SearchInMatrix searchSample = new SearchInMatrix();
        boolean isFound = searchSample.SearchInMatrix(matrix, 13);
        System.out.println("Did we found the element: "+isFound);
    }
}
