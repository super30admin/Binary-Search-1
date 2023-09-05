// Time complexity is: O(Log m*n)
// Space Complexity is: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
		// row size
		int m= matrix.length;
		// col size
        int n = matrix[0].length;
        int lb=0;
        int hb=m*n-1;
        
       
      
        while(lb<=hb){
            
            // to prevent overflow
              int mid = lb+(hb-lb)/2;

			// computing row num
			 int r= mid/n;
			 
			// computing col num
              int c= mid%n;
             if(target==matrix[r][c])
                  return true;
             else if(target < matrix[r][c]){
                 hb=mid-1;
             }
             else{
                 lb=mid+1;
             }
            
        }
        return false;
        
    }
}