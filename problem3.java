//time complexity-O(log(m*n)){m-to search the range,n-to search in the range}
//space complexity-O(1)
//the approach is that we start with low=0 ang high=1 and go on expand the high until we get the range in which our target lies and apply binary search on it.
public class Solution {
    public static int ninjaAndInfiniteSizeArray(InfinteSizeArray obj, int target) {
        // Write your code here.
        int low = 0, high = 1;
        while (target > obj.readValueAtIndex(high)) {
            high *= 2;
        }
        low = high / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (obj.readValueAtIndex(mid) == target) {
                return mid;
            } else if (obj.readValueAtIndex(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
