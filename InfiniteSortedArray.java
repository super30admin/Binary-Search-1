/* Time Complexity : O(logn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach in three sentences only
Increasing range by 2x till high becomes out of range; Then finding mid and then checking
if it is valid. If it's valid and bigger than the target; then target lies between low and mid(apply binary search)
else low = mid + 1
*/

class InfiniteSortedArray {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        int mid;
        int midValue;

        // increasing the search area by 2x
        while (target > reader.get(high)) {
            low = high;
            high = high * 2;
        }

        // searching in this range
        while (low <= high) {
            mid = low + (high - low) / 2;
            midValue = reader.get(mid);

            if (midValue == target)
                return mid;

            if (midValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}