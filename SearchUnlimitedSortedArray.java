// Time Complexity: O(logn) + O(log m)
//space complexity: O(1)
//leetcode: Yes.

//this program will not run on the editor..making a note for future reference try this on leetcode.
public class SearchUnlimitedSortedArray {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        int mid = 0;
        //this should be loop and not an if condition the logic is to find the boudnaries first and then do binary search
        while (target > reader.get(high)) {
            //we know elemenet is to the right
            low = high;
            high = high * 2;
        }

        while (low <= high) {
            mid = low + (high - low)/2;
            if (target == reader.get(mid)) {
                return mid;
            } else if (target > reader.get(mid)) {
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }
}
