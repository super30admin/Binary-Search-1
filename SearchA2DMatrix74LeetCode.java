//Time Complexity : O(logn)
//Space Complexity : O(1)
// Yes, It's run successfully
// No I don't face any problem.


public class SearchA2DMatrix74LeetCode {

    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int column = matrix[0].length;

        int start = 0;
        int end = row*column-1;

        while (start <= end){
            int mid = start+ ( end - start )/2;

            int i = mid / column;
            int j = mid % column;

            if(matrix[i][j]==target){
                return true;
            }
            else if(matrix[i][j]<target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args){

        SearchA2DMatrix74LeetCode object = new SearchA2DMatrix74LeetCode();

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(object.searchMatrix(matrix, target));
    }
}
