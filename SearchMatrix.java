// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only

class SearchMatrix {
    /*public boolean searchMatrix(int[][] matrix, int target) {
        int i=0,j=matrix[0].length-1;
        while (i < matrix.length && j >= 0){
            if (target > matrix[i][j]){
                i++;
            } else if (target < matrix[i][j]){
                j--;
            } else {
                return true;
            }
        }
        return false;
        
    }*/

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int low = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int high = (n * m) -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (matrix[mid/m][mid%m] == target) return true;
            else if (matrix[mid/m][mid%m] > target) high = mid -1;
            else low = mid +1;
        }  
        return false;      
    }

    public static void main(String[]args){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        SearchMatrix sm = new SearchMatrix();
        System.out.println(sm.searchMatrix(matrix, target));
    }
}