//Time Complexity : O(log (raw * col)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class SearchTargetInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
         int m=matrix[0].length;
          int n=matrix.length;
        int low=0;
        int high=m*n-1;
         while(low<=high){
            int mid=low+(high-low)/2;
             int r=mid/m;
             int c=mid%m;
             if(matrix[r][c]==target){
                 return true;
             }
             else 
                 if(matrix[r][c]>target){
                     high=mid-1;
                 }
             else
             {
                 low=mid+1;
             }
         }
        return false;
    }
    public void main(String args[]) {
    	int arr[][]= {
        {1,3,5,7},{10,11,16,20},{23,30,34,60}
        };
    	SearchTargetInMatrix ob=new SearchTargetInMatrix();
    	System.out.print(ob.searchMatrix(arr, 3));
    }
}
