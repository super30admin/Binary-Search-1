// Time Complexity : O(log(n)) + O(log(range))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, initially I could not understand how are we using reader interface and how are we optimizing search criteria based on huge range
// Approach: Starting with low as 0 and high as 1, gradually increment the range by twice and set initial pointer of low to previous high, perform binarySearch over the range.
// Out of Bound conditions are handled for mid as well as high, as it will still reduce the search space by half.
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class SortedUnknownArrayElement {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        // Check if high is not out of bound and target is more than high value
        // In this case increase the range by factor of 2
        while(reader.get(high) != Integer.MAX_VALUE && target > reader.get(high)) {
            low = high;
            high = high * 2;
        }
        return binarySearch(reader, low, high, target);
    }
    public int binarySearch(ArrayReader reader, int low, int high, int target) {
        // Traditional binary search
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(reader.get(mid)==target) {
                return mid;
            } else if(reader.get(mid)>target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
