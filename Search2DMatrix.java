import java.util.*;
import java.lang.*;
import java.io.*;

class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        // intializing left to 0 and right two number of elements in matrix -1 to cover the entire space and apply binary Search
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        //run a while loop until left<=right if not found then return false;
        while (left <= right) {
            //finding values for pivot index and pivot element
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            // return true if pivotElement value equlas the target value
            if (target == pivotElement)
                return true;
            else {
                // if target < pivotElement the decerement the right index
                if (target < pivotElement)
                    right = pivotIdx - 1;
                //else increment the left index to decrease the input size search space
                else
                    left = pivotIdx + 1;
            }
        }
        // if element not found in while loop then return false;
        return false;
    }
    public static void main(String[] args){
        Search2DMatrix ob = new Search2DMatrix();
        int[][] arr = {{1,2,3},{5,6,7},{8,9,10}};
        System.out.println(ob.searchMatrix(arr, 8));
        System.out.println(ob.searchMatrix(arr, 4));
    }
}

//Time complexity - O(logm*n)
//Space complexity = O(1)
