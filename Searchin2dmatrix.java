class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low=0;
        int high = m*n-1;
        while( low <= high){

            // find mid
            int mid = low + ( high- low)/2;
            int row = mid / n ;
            int col = mid % n;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }

        }
        return false;
    }
}

another slolution: time : o (m) + o log(n)

class Solution {


    public boolean binarySearch(int row[], int target){

        int low =0;

        int high = row.length -1;

          while(low <= high){
                      int mid = low + (high - low)/2;
                      if(row[mid]== target ) return true;
                      else if(row[mid] < target){
                          low = mid +1;
                      }else{
                          high = mid - 1;
                      }
          }    
          return false;       
    }
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;// row
        int n = matrix[0].length; // column

        for(int i =0 ; i < m ; i++){
           
        

                if(matrix[i][0] <= target && matrix[i][n-1] >= target)
                  {
                      return binarySearch(matrix[i], target);
                     
                  }
            }
             return false;
        }
       
    }
				