// Time Complexity : O(log m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int low = 0;
        int high = matrix.length-1;
        int mid = low + (high-low)/2;

        // Identify column
        while(low < high){
            if(matrix[mid][0] < target){
                if(matrix[mid][matrix[mid].length-1] >= target) {
                    low = mid;
                    break;
                }
                low = mid+1;
            } else {
                high = mid;
            }
            mid = low + (high-low)/2;
        }

        // low signifies the row to search;
        int[] search = matrix[low];

        low = 0;
        high = search.length;
        mid = low + (high-low)/2;

        // Identify column
        while(low < high){
            if(search[mid] < target){
                low = mid+1;
            } else {
                high = mid;
            }
            mid = low + (high-low)/2;
        }

        //System.out.println("Last searched: " + search[low]);

        return low < search.length && search[low] == target;

    }
}
