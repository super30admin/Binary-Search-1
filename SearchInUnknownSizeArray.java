// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No (since this question is available on leetcode premium)
// Any problem you faced while coding this : yes , In finding the ranges (i.e what should be the high value) 
public class SearchInUnknownSizeArray {
    public static int search(int[] arr , int target) {
        int low = 0;
        int high = 1;
        while(target > arr[high]) {
            low = high;
            high = high*2;
        }
        return binarySearch(arr,low,high,target);
    }

    private static int binarySearch(int[] arr, int low, int high, int target) {

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target)
                high = mid - 1;
            else 
                low = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        int target = 9;

        int result = search(arr, target);
        System.out.println(result);
    }
    
}
