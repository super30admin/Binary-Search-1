
// Time complexity: O(lg(mn))
//space complexity:O(1)
//// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :No 

public class TwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0){
            return false;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high=m*n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int r=mid/n;
            int c=mid%n;
            if(matrix[r][c]==target){
                return true;
            }
            else if(target<matrix[r][c]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
    public static void main(String args[]){
        TwoDMatrix obj=new TwoDMatrix();
       int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
       int  target = 3;
       System.out.println(obj.searchMatrix(matrix, target));
    }
}