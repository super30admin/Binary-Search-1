class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int index = 0;
        int lastElementIndex;
        if(matrix.length==1 && matrix[0].length==1){
            if(matrix[0][0]==target){
                return true;
            }
            else return false;
        }
        
        lastElementIndex=matrix[0].length-1;
        
        for(int i=0; i<matrix.length;i++){
            if(matrix[i][lastElementIndex] >= target){
                index=i;
                if(matrix[i][lastElementIndex] == target){
                    return true;
                }
                break;
            } else{
                continue;
            }
        }
        
        
        int start =0;
        int end = lastElementIndex;
        while(start<= end){
            int mid = (start+end)/2;
            if(matrix[index][mid] == target){
                return true;
            }
            else if(matrix[index][mid]<target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return false;
        
        
        
    }
}