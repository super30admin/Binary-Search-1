// Time Complexity : o(logN)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : i dont have premium
// Any problem you faced while coding this : no
public class search_in_unknownsize {
    public int search(ArrayReader reader,int target) {
        int low = 0;
        int high = 1;
        while(reader(high) < target) { // we increase the array size slightly each time and apply binarysearch
            low = high;
            high = 2 * high;
        }
        return binarySearch(reader, target, low, high);
    }
    private int binarySearch(ArrayReader reader, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(reader(mid) == target) {
                return mid;
            }
            else if(reader(mid) > target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
