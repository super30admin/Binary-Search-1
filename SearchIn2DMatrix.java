/*
Time Complexity : O(log n) binary search * 2
Space Complexity : O(1) since we create memory when array is generated

Did this code successfully run on Leetcode :
Finished in 68 ms
true

Any problem you faced while coding this :
Wasted a lot of time trying to make the two binary search as one function. Eventually gave up

Your code here along with comments explaining your approach :
binary search vertically then binary search horizontally

The comments after sysouts were expected output and they matched.
*/
public class SearchIn2DMatrix {
    static boolean binaryVSearch(int [][]arr, int low, int high, int key, int n){
        if (high < low)
            return false;
        int mid = (low + high) / 2;
        if (key == arr[mid][0])
            return binaryHSearch(arr[mid], 0, n, key);
        if (key > arr[mid][0]){
            if(key <= arr[mid][n-1])
                return binaryHSearch(arr[mid], 0, n, key);
            return binaryVSearch(arr, (mid + 1), high, key, n);
        }
        return binaryVSearch(arr, low, (mid - 1), key, n);
    }

    static boolean binaryHSearch(int []arr, int low, int high, int key){
        if (high < low)
            return false;
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return true;
        if (key > arr[mid]){
            return binaryHSearch(arr, (mid + 1), high, key);
        }
        return binaryHSearch(arr, low, (mid - 1), key);
    }


    public static void main(String[] args) {
        
        int [][]matrix = {{1,2,3,4},{6,7,8,11},{12,13,14,15},{16,17,19,21},{22,23,24,25}};
        int m = matrix.length;
        int n = matrix[m-1].length;

        System.out.println( SearchIn2DMatrix.binaryVSearch(matrix, 0, m, 8, n));//true
    }
}
