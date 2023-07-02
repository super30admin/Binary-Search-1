// Time Complexity : log(n)
// Space Complexity : log(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class InfiniteSortedArraySearch {
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */


    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        //this will find my low and high index of unknown size array
        while(reader.get(high) < target){
            low = high;
            high = 2*low;
        }
        // Apply binary search approach to find the element
        while(low<=high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(low) <= target && reader.get(mid) > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}