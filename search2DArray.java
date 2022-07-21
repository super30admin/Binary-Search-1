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
