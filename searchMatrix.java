// Time Complexity : O(NlogN)
// Space Complexity : O(NlogN)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows*columns - 1;
        while(left<=right){
        // check the initial condition
        }
            int mid_point = left + (right - left) / 2;
            //Calculate the midpoint of the given matrix
            int midpoint_element = matrix[mid_point/columns][mid_point%columns];
            // to locate the position of the mid- point elemnent and then by binary search algorithm we can get the midpoint of the element.
            if(midpoint_element == target) return true;
            else if(midpoint_element<=target){
                left = mid_point + 1;
            }else if(midpoint_element>target){
                right = mid_point - 1;
            }
        }
        return false;

    }
}


// Your code here along with comments explaining your approach
