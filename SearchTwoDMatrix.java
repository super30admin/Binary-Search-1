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


//Technique 2: 1-D Array concept and Binary Search 
//Time Complexity :  O(log(mn) 
// Space : Complexity : O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        
        int m = matrix.length; //row
        int n = matrix[0].length; //column
        
        int low = 0;
        int high = m*n -1 ; 
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            //Find the r, c positions of Array[mid] in matrix by using mid index

            int r = mid/n ; // n is column 
            int c = mid%n;
            
            if(matrix[r][c] == target){
                return true;
            }
            else if(matrix[r][c] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}



//Technique 3: Binary Search on Last Column and Binary Search on that particular row
//Time Complexity :  O(log(m) + log(n))
//Space : Complexity : O(1)

//Technique 4: Brute Force 
//Time Complexity :  O(mn)
//Space : Complexity : O(1)
