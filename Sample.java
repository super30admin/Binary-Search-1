// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Logic behind 2D to 1D array conversion assumption was difficult to understand.

// Your code here along with comments explaining your approach
public class SearchSample {
   
   //Time: O(1) - We are not iterating all the elements. Treating a 2D array 1D then following binary search tree.
   //Space:O(1) - We are just creating memory it doens't change much. I think its constant space
    public boolean SearchInMatrix(int[][] matrix, int target) {

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        if(rowLength == 0) return false;

        int low = 0;
        int high = (rowLength * colLength) - 1;

        while(low <= high) {
            int midIndex = (low + high)/2;
            int midValue = matrix[midIndex/colLength][midIndex%colLength];

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
        SearchSample searchSample = new SearchSample();
        boolean isFound = searchSample.SearchInMatrix(matrix, 13);
        System.out.println("Did we found the element: "+isFound);
    }
}
