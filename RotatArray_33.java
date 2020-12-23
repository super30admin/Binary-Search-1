// Time Complexity :O(log(m*n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :mapping the the midpoint element to matrix.


// Your code here along with comments explaining your approach

//one way is the brute force approach which will take O(n^2)
class SolutionBrute {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}
//But as it is given that the rows of the matrix are sorted.So we can employ binary search here.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int start=0;
        int end=(matrix.length*matrix[0].length)-1;
        int midPoint=0;
        int element=0;
        while(start<=end){
             midPoint=start+(end-start)/2;
             element=matrix[midPoint/matrix[0].length][midPoint%matrix[0].length];
            if(element==target){
                return true;
            }else if(target<element){
                end=midPoint-1;
            }else if(target>element){
                start=midPoint+1;
            }
        }
        return false;
    }
}