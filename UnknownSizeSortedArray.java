/*
* Approach:
*  1. Finding the correct range of target by increasing 
        the search space(high) by twice and
        getting the low to prev high position. 
* 
*  2. Once search space is found, apply Binary Search in
        the range of low and high.
* 
*   Why twice?
        if we are increasing the high by thrice, four, five times,...
        we might find the correct range quickly,
            but binary search range will increase and affect the complexity. 

* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(logM) + O(logK) === O(logN)
            M -> jumps to find the correct range
            K -> range of elements in the valid range
        log is for base 2.

            worst case range can be N
* 
* Space Complexity: O(1)
* 
*/
public class UnknownSizeSortedArray {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;

        // finding the correct search space
        while (reader.get(high) < target) {
            low = high;
            high *= 2;
        }

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (reader.get(mid) == target)
                return mid;

            else if (reader.get(mid) < target)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return -1;
    }
}
