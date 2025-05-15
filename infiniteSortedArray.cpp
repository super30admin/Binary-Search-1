// Time Complexity : O(log N), where N is the index of the target or the nearest bound
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// I had trouble figuring out how to determine the upper bound for binary search.
// If I searched or went in linear fashion it would be a O(N) time which is not the expected time limit. 
// I wasn’t sure how to logically set the maximum search limit without knowing the array size.
//  To get those search limits I have used some external resources. 
// Once the bounds were established, implementing binary search was straightforward.

// Your code here along with comments explaining your approach in three sentences only:
// I used exponential backoff to find an appropriate upper bound since the array size is unknown.
// Once the bound was found, I applied a standard binary search between the lower and upper bounds.
// I also handled the case where the index is out of bounds by checking for INT_MAX, as specified in the problem.

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int left = 0;
        int right = 1;

        // Step 1: Find bounds for binary search using exponential backoff
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }

        // Step 2: Perform binary search between left and right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = reader.get(mid);

            if (val == target)
                return mid;
            else if (val > target || val == INT_MAX)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }
};
