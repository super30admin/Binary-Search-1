// Time Complexity :  Worst case: O(log2 N); Best case: O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
/** 
 * Calculating how exactly the indexes of the middle element can be fetched 
*/

// Your code here along with comments explaining your approach
/* Treat this array as a 1-D array
    1. The index of the middle element can always be found using row=mid/numberOfColumns and col=mid%numberOfColumns
    2. Setting up high as the index of last element, which would be numberOfColumns*numberOfRows-1
*/
class SolutionTwoDimArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        int numberOfColumns = matrix[0].length;
        int numberOfRows = matrix.length;
        int high = numberOfRows*numberOfColumns-1;
        int low = 0; int mid; int colForMid; int rowForMid;
        if(matrix==null || matrix.length==0)
            return false;
        while(low<=high)
        {
            mid = (low+(high-low)/2); //Use this instead of (low+high)/2 as if the index number is really huge, low+high could lead to a value way bigger                                       //to fit in int
            rowForMid = mid/numberOfColumns;
            colForMid = mid%numberOfColumns; 
            int middleElement = matrix[rowForMid][colForMid];
            if(middleElement==target) //If the middle element is the target element, return true
                return true;
            else if(middleElement>target) //If it is greater than the target, then we need to search in the left half. Hence move the higher pointer to left half
                high=mid-1;
            else //Otherwise, search the right half. Hence move the lower pointer to right half
                low=mid+1;
        }
        return false;
    }
}
