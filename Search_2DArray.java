//TC is log(m)+log(n) which is same as log(m*n)
//SC: O(1)

// Flatten the 2D array(visiualize) - it'll be sorted and apply binary search
// The take away to find the position of a particular indx in matri. see below:
// indx / (no. of cols) = row
//indx % (no. of cols) = col

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = m*n-1;

        while(low<=high){
            int mid = low + (high -low)/2;

            int r = mid / n;
            int c = mid % n;

            if(matrix[r][c] == target){ 
                return true;
            }else if(matrix[r][c] < target){
                low = mid+1;
            }else{
                high = mid-1; 
            }
        }
        return false;
    }
}