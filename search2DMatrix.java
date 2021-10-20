// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
            
        for(int i =0; i< m; i++){
            if(target<=matrix[i][n-1]){
                if(target>=matrix[i][0]){
                    
                   int start = 0;
                   int end = n-1;
                    
                    while(start<=end){
                      int mid = start +(end - start)/2;
                      
                    if(matrix[i][mid]==target){
                        return true;
                    }    
                    else if(matrix[i][mid]<target){
                        start = mid + 1;
                    }else{
                        end = mid -1 ;
                    }
                        
                    }
                    
                    return false;
                }
            }
        }
        return false;
    }
}