// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Don't have premium. 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*Since we don't know the upper bound, we start with 0 and dynamically double the length based on the input. 
We then use binary search and split the array into two. 
Searching takes place in either left half or right half. 

 */

class InfiniteSortedArray {
public static int searchInUnknownLengthArray(int[] arr, int target) {
    // Find upper bound for array length
    int idx = 0;
    while (true) {
        try {
            if (arr[idx] >= target) {
                break;
            }
            idx = idx * 2 + 1;
        } catch (IndexOutOfBoundsException e) {
            break;
        }
    }

    // Binary search
    int lo = 0, hi = idx;
    while (lo <= hi) {
        int mid = (lo + hi) / 2;
        try {
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        } catch (IndexOutOfBoundsException e) {
            hi = mid - 1;
        }
    }

    return -1; // target not found
}
}