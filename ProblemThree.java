/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
// Did this code successfully run on Leetcode : Yes
 // TC: O(logn)
 // SC: O(1)
 // Use binary search since the array is sorted
 // Start with array of size 2 and then increment by doubling size till we find if the target is in our range and then use binary search to find the element
class ProblemThree {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target){
            return 0;
        }

        int low = 0;
        int high = 1;
        int mid;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(reader.get(mid) == target) return mid;
            if(target < reader.get(mid)){
                high = mid - 1;
            } else {
                high = high * 2;
                low = mid + 1;
            }
        }

        return -1;

    }
}