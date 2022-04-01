// Time Complexity : O(log (m x n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach : Using binary search using hashing to get the indices


class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int high = m * n -1;
        int mid;
        
        while(low<=high){
            mid = high - (high - low)/2;
            
            int mindex= mid / n;
            int nindex=  mid % n;
            
            if(target == matrix[mindex][nindex]){
                return true;
            }
            
            if(target <= matrix[mindex][nindex]){
                high = mid - 1;
                
            }else{
                low = mid + 1;
            }
            
        }
        
        return false;
    }

    public static void main(String args[]){
        MatrixSearch solution = new MatrixSearch();

       int[][] matrix = {{1,2},{3,4}} ;
       System.out.println(solution.searchMatrix(matrix, 4)); 
    }
}