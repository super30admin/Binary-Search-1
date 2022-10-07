import java.util.ArrayList;
// Time Complexity : log(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class searchMatrix {

    public boolean searchMatrix(int[][] matrix, int target){

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m*n-1;

        int index;
        int element;

        while(low <= high){

            index = (low+high)/2;
            element = matrix[index/n][index%n];

            if( target == element){
                return true;
            }else{

                if( target < element){
                    high = index-1;
                }else{
                    low = index+1;
                }

            }

        }

        return false;
    }

}
