// Time Complexity : O(log(m*n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
//considered 2d array as single array start at (0,0) to till (m-1,n-1), index values will range from 0 to (m*n)-1
//then we find the mid and convert it to coordinates by checking offsets using col
//then make at decision to cutoff the part that doesn't include target


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        int i=0,j=row*col-1;
        while(i<=j){
          int mid=i+(j-i)/2; 
          int x=mid/col;
          int y=(mid)%col;
          //System.out.println(a+" "+b+" "+c+" "+d+" "+x+" "+y);
          //System.out.println(i+" "+j+" "+mid+" "+x+" "+y);
          if(matrix[x][y]==target)return true;
          if(matrix[x][y]<target){
            i=mid+1;
          }else{
            j=mid-1;
          }
        }
        return false;
    }
}