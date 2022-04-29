//Time Complexity: O(log(mn))
//Space Complexity: O(1)


public class SearchMatrixSolution {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length==0){
            return false;
        }

        int n=matrix[0].length;
        int m = matrix.length;

        int low=0;
        int high=n*m-1;

        while(low<=high){

            int mid = low+(high-low)/2;
            int row = mid/n;
            int column = mid%n;

            if(matrix[row][column] == target){
                return true;
            }else if(matrix[row][column]> target){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }

        return false;

    }
}
