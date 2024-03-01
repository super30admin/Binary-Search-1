// Time Complexity : O(logm + logn) logm is for the range and logn is for the binary search algo
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
*  BruteForce - Take high as Integer_MAX_VALUE and apply binary search
*  Optimized approach - We initially check if the target is at the first index, returning 0 if true.
* Then we expand the search range exponentially until it exceeds the target value, updating left and right pointers accordingly.
*  Finally, it performs a standard binary search within the identified range, returning the index of the target if found, or -1 if not found.
*
* */

public class Search_isa {

    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0;

        int left = 0, right = 1;
        while (reader.get(right) < target) {
            left = right;
            right <<= 1;
        }

        int pivot, num;
        while (left <= right) {
            pivot = (left + right) / 2;
            num = reader.get(pivot);

            if (num == target) return pivot;
            if (num > target) right = pivot - 1;
            else left = pivot + 1;
        }

        return -1;
    }
}
