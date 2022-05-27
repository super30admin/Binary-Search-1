
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int mLenght = matrix.length;
        int i =0;
        while(i < mLenght){
            if(matrix[i][matrix[i].length-1] >= target) break;
            i++;
        }
        if(i > mLenght-1) return false;
        int min = 0;
        int max = matrix[i].length;
        while(min <= max){
            int mid = (min + max)/2;
            if(matrix[i][mid] == target) return true;
            if(matrix[i][mid] <= target){
                 min = mid +1;
            } else {
                max = mid -1;
            }
            
        }
        return false;
    }
}