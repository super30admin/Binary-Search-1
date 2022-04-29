import java.lang.annotation.Target;

public class Search2D {
    // normal binary searcg log(n) complexity
    public boolean binarySearch(int[] arr, int first, int last, int target){
        while(first<=last){
            int mid = first+(last-first)/2;
            if(target<arr[mid]){
                last = mid-1;
            }
            else if(target>arr[mid]){
                first = mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
    // search the rows. log(N) time complexity
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int first =0, last = rows-1;
        while(true){
            if(first>last){
                return false;
            }
            if(first == last){
                return binarySearch(matrix[first],0, columns-1, target);
            }
            int middle = first+(last-first)/2;
            if(target < matrix[middle][0]){
                last = middle-1;
            }
            else if(target > matrix[middle][columns-1]){
                first = middle+1;
            }
            else{
                return binarySearch(matrix[middle], 0, columns-1, target);
            }
        }

    }
}
