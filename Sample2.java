// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : It is not available for free
// Any problem you faced while coding this : Had to spend more time. 


// Your code here along with comments explaining your approach

public class InfiniteArray(int[] arr, int target) {

    int i = 0;
    int j = 1;

    if (arr[i] == target) return i;

    // If the element is not found on the 2nd position
    // update the value of i and j 
    // double the value of j 
    // Finally we will get a range where we can find the target value
    do {
        if(arr[j] == target) return j;
        i = j;
        j *= 2;
    } while(arr[j] < target);

    // Perform binarySearch and return the index of the target value
    return binarySearch(i, j, arr);
}

public int binarySearch(int start, int end, int[] arr) {

    if (start <= end) {

        int mid = start + (end - start)/2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch(start, mid - 1, arr);
        } else {
            return binarySearch(mid + 1, end, arr);
        }
    }
    return -1;
}