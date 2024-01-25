public class InfiniteSortedArray {
    /** Time Complexity : O(log n)
     Space Complexity : O(1)
     Did this code successfully run on Leetcode : Not subscribed to leetcode. Hence, unable to access this question.
     Any problem you faced while coding this : No


     Your code here along with comments explaining your approach in three sentences only **/
    public int searchIndexArr(int arr[], int num) {
        //Using Binary Search Algorithm to find the index of the number in an sorted infinite array
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
        //Returns the index of the number if its present in the middle part of the array
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                //Adjusts the search if the number is present in the left part of the sorted array
                left = mid + 1;
            } else {
                //Adjusts the search if the number is present in the right part of the sorted array
                right = mid - 1;
            }
        }
        //Returns -1 when the number is not present in the infinite sorted array.
        return -1;
    }
}
