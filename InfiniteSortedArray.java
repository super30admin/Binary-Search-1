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
    // max possible value is 10000
    int MAX_SECRET = 10001;

    // simple binary search algorithm
    public int binarySearch(ArrayReader reader, int low, int high, int target) {
        int mid;
        int midValue;
        while (low <= high) {
            mid = Math.round((low + high) / 2);
            midValue = reader.get(mid);

            if (target == midValue)
                return mid;

            if (target < midValue) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int search(ArrayReader reader, int target) {
        int high = 1;
        int low = 0;
        int mid;
        int midValue;

        // increasing the search area by 2x
        while (target > reader.get(high)) {
            low = high;
            high = high * 2;
        }

        // if high is out of bounds; ideally compare with 2^31 - 1
        while (low <= high && reader.get(high) >= MAX_SECRET) {
            mid = Math.round((high + low) / 2);
            midValue = reader.get(mid);

            if (midValue == target)
                return mid;

            // mid value is also out of bounds
            if (midValue >= MAX_SECRET) {
                high = mid - 1;
            } else {
                // mid is valid index but bigger than target
                if (midValue > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return binarySearch(reader, low, high, target);
    }
}