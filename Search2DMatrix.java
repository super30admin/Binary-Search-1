// Time Complexity : O(log(mn)) m,n is size of row*col = matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Search2DMatrix {
    /*
    We determine mid by low+high/ We determine row = mid/n and col = mid%n and thus we know pos of mid.
    Once we have this we perform binary search on the same.
    @param: matrix, target
    @return: none
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int n = matrix[0].length;
        int high = (matrix[0].length*matrix.length)-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col]==target){
                return true;
            }
            else if(target<matrix[row][col]){
                high = mid-1;
            } else {
                low=mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,3,5,7}, {10,11,16,20},{25,30,34,60}};
        int target = 3;
        Search2DMatrix obj = new Search2DMatrix();
        System.out.println(obj.searchMatrix(matrix,target));
        target = -1;
        System.out.println(obj.searchMatrix(matrix,target));
    }
}