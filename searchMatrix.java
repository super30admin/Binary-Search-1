class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix[0].length;
        
        if(target < matrix[0][0]) return false;
        
        int l=0,r=(matrix.length*len)-1;


        while(l<=r){
            int mid = l+(r-l)/2;
        
            int row = mid/len;
            int col = mid%len;
            
            if(matrix[row][col]==target){
                return true;
            }
            
            else if(target < matrix[row][col]) r=mid-1;
            
            else l=mid+1;
        }

        return false;
    }

}


/*class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix[0].length;
        
        if(target < matrix[0][0]) return false;
        
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] <= target && matrix[i][len-1] >= target ){
                return binarysearch(matrix[i],target,0,len-1);
            }
        }

        return false;
    }

    public boolean binarysearch(int[] row,int target,int l, int r){
        int mid = (l+r)/2;

        if(l>r) return false;

        if(row[mid]==target){
            return true;
        }
        if(target<row[mid])
           return binarysearch(row, target, l, mid-1);
        else
          return binarysearch(row, target, mid+1, r);
        
       
    }
}
*/