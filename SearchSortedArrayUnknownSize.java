// Time Complexity : O(log n + log m ) where n is the number of elements in input array and m is the number of steps in multiplying high by 2
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class SearchSortedArrayUnknownSize {
    public int search(ArrayReader reader, int target) {

        int low =0;
        int high = 1;

        while (reader.get(high) < target){
            low = high;
            high = 2 * high;
        }

        while (low <= high){

            int mid = low + (high - low) /2;

            if(reader.get(mid) == target)
                return mid;

            else if(reader.get(mid) > target)
                high = mid -1;

            else low = mid +1;
        }
        return -1;
    }
}