// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        boolean result = false;
        for(int i = 0;i < rowLength; i++){
            int colLength=matrix[0].length;
            if(target >= matrix[i][0] || target <= matrix[i][colLength-1]){
                if(binarySearch(matrix[i],0,colLength-1,target)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean binarySearch(int[] subMatrix, int low,int high,int target){
        int mid = (low+high)/2;
        while(high >= low){
            if(subMatrix[mid] == target){
                return true;
            }
            if(subMatrix[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
            mid = (low+high)/2;
        }
        return false;
    }
}