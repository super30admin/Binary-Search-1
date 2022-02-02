

class Solution {
  // space complexity - o(n*m)
  	//time - o(n+m))
    //Ran on leeetcode successfully : Yes
    // Problem faced  : No
  	//Approach :
        // Brute force would be to check all elements o(n*m)
    	// IN optimized Brute Force, we move along the diagonal (we start from left bottom or right top coordinate)
    	// we cannot start from a point where both row and column decrease or increase i.e (0,0) or (end, end) coordinate will not work
    public boolean searchMatrix(int[][] matrix, int target) {

      if(matrix == null || matrix.length ==0 ) return false;

        int i = matrix.length-1;
        int j  = 0;

        while(i>=0 && j < matrix[i].length-1 ){

          if(matrix[i][j] == target) return true;
          else if(matrix[i][j] < target){
            j++;
          }
          else{
            i--;
          }
        }
        return false;
    }
    // space complexity - o(n*m)
    	//time - o(log(n*m))
      //Ran on leeetcode successfully : Yes
      // Problem faced  : No
    	//Approach : since it is sorted in spiral way, we ca think of this 2 array as 1D array (row place one after the other)
        // once we find the mid we need to get to the cell by using (int x = mid/m int y = mid%m; ).
    public boolean searchMatrixOptimised(int[][] matrix, int target) {

      if(matrix == null || matrix.length ==0 ) return false;

        int n = matrix.length;
        int m = matrix[0].length;

        int start = 0;
        int end = n*m-1;
        int mid = start + (end - start)/2;

        while(start <= end){

            mid = start + (end - start)/2;

            int x = mid/m;
            int y = mid%m;

            if(matrix[x][y] == target){
                return true;
            }
            else if(matrix[x][y] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }


        return false;
    }
}
