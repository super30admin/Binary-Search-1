// Time Complexity : O(m+n) since it will check vertially all values once and than horizontally . . (not sure though) 
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// started from the right top corner, it tagret is less than that element reduce endIndex, if target value is more than that element go to next array by 
// increasing start index. at any point we find target return true

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startIndex=0,endIndex = matrix[0].length-1;
        
        while(startIndex <= matrix.length-1 && endIndex >= 0){
            if(matrix[startIndex][endIndex]==target)
                return true;
            else if(target < matrix[startIndex][endIndex])
                endIndex--;
            else if(target > matrix[startIndex][endIndex])
                startIndex++;
        }
        return false;
    }
}
