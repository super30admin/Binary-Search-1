//Technique 1: Binary Search 
//Time Complexity :  O(mlogn)
//Space : Complexity : O(1)


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        
        int m = matrix.length; //row
        int n = matrix[0].length; //column

        for(int i=0; i< m; i++){ // m rows
 
            if(matrix[i][n-1] == target){
                
                return true;
            }

            else if(matrix[i][n-1] > target){
                //Binary Search
                int low = 0; int high = n-1;
                while(low<=high){  // logn                     
                    int mid = low+(high-low)/2;     
                    if(matrix[i][mid] == target){
                        return true;
                    }
                    else if(matrix[i][mid] > target){
                        high = mid-1;
                    }
                    else{
                        low = mid+1;
                    }
                }
             return false;
            }
            else{
                continue;
            }
        }
        return false;
    }
}
