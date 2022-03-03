/*
Time Complexity : O(log n) binary search
Space Complexity : O(1) since we create memory when array is generated

Did this code successfully run on Leetcode :
Finished in 68 ms
-1
4

Any problem you faced while coding this :
None

Your code here along with comments explaining your approach :
pivot where it is rotating pivot and then simple binary search 

The comments after sysouts were expected output and they matched.
*/
public class RotatedSortedArray {
    static int binarySearch(int []arr, int low, int high, int key){
        if (high < low)
            return -1;
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }

    static int pivotedBinarySearch(int []arr, int key){
        int n = arr.length;
        int pivot = findPivot(arr, 0, n - 1);
 
        if (pivot == -1)
            return binarySearch(arr, 0, n - 1, key);
 
        if (arr[pivot] == key)
            return pivot;
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot - 1, key);
        return binarySearch(arr, pivot + 1, n - 1, key);
    }

    static int findPivot(int []arr, int low, int high){
        if (high < low)
            return -1;
        if (high == low)
            return low;
 
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }

    public static void main(String[] args) {
        int []arr = {9, 11, 1, 3, 4 ,7 ,8};
        System.out.println(pivotedBinarySearch(arr, 5));//-1
        System.out.println(pivotedBinarySearch(arr, 4));//4
         
    }
 
}
