// Time Complexity : Binary search complexity is O(log n) but the initial method to find the range by multiplying 2 would be again O(log n). So twice*O(log n)
// Space Complexity : O(1) ; Storing only variables, no extra space required.
// Did this code successfully run on Leetcode : No // This problem requires premium subscription
// Any problem you faced while coding this : No
// My Notes : - Here the constraint is 10^4, can directly do it, but since it is B.S they need to use the 
import java.util.ArrayList;
import java.util.Arrays;

class UnknownSize {

    /**
     * Default ArrayReader created for testing purposes.
     */
    class ArrayReader {

        private ArrayList<Integer> list = null;

        ArrayReader() {
            list = new ArrayList<Integer>(
                    Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        }

        public int get(int index) {
            if (index >= list.size()) {
                return Integer.MAX_VALUE;
            }
            return list.get(index);
        }

    }

    public int search(ArrayReader reader, int target) {
        int start = 0, end = 1;

        // The loop wont enter if the value present in first two index
        // Find the end and store start with previous end
        while (reader.get(end) < target) {
            start = end + 1; // Setting start to the last end value
            end = end * 2; // Doubling end value to avoid linear time
        }
        System.out.println(" search range start,end " + start + "," + end);

        int mid = 0;
        // Traditional iterative binary search
        while (start <= end) {
            mid = start + (end - start) / 2;
            // System.out.println("Value of start,end,mid " + start + "," + end + "," + mid);
            if (target == reader.get(mid)) {
                return mid; // returing idx of elem found
            } else if (target < reader.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1; // if no elem found
    }

    public static void main(String[] args) {
        System.out.println("Hey there");
        UnknownSize obj = new UnknownSize();
        UnknownSize.ArrayReader reader = obj.new ArrayReader();
        System.out.println(obj.search(reader, 1)); // Will return 0 Search Range : [0..1]
        System.out.println(obj.search(reader, 2)); // Will return 1 Search Range : [0..1]
        System.out.println(obj.search(reader, 7)); // Will return 1 Search Range : [5..8]
        System.out.println(obj.search(reader, 15)); // Will return 14 Search Range : [9..16]
    }
}