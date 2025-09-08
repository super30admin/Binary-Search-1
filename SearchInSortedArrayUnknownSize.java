// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//Approach: The range is a problem here because the array length is unknown, which means high is unknown.
//We would need 2 binary searches, 1 to find the range, the other to find the element
public class SearchInSortedArrayUnknownSize {

    /**
     *
     * @param reader an interface that holds an unknown number of integers, think of it as an array of unknown size
     * @param target the target to find
     * @return       the index of the target in the array
     */
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        while (reader.get(high) < target) high *= 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target) return mid;
            else if (reader.get(mid) > target) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }
}

interface ArrayReader {
    int get(int index);
}