#time complexity = O(log m*n)
 #space complexity = O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int h = m*n -1;
        while(h>=l){
            int mid = l+(h-l)/2;
            int x = mid/n;
            int y = mid%n;
            if(matrix[x][y] == target) return true;
            if(target > matrix[x][y]){
                l = mid+1;                
            }else{
                h = mid-1;
            }      
        }
        return false;
    }
}
