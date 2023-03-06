public class SearchInInfiniteSortedArray {

    /*Time Complexity - O(log(N))
     * Space Complexity - O(1)
     * Did this code successfully run on Leetcode : Not able to run on leetcode as its a premium problem
     * Any problem you faced while coding this : No
     * */

    public int search(ArrayReader reader, int target) {
        int left = 0;
        if (reader.get(left) == Integer.MAX_VALUE) {
            return -1;
        }
        int right = reader.length();

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int midElement = reader.get(mid);

            // Target found
            if (target == midElement) {
                return mid;
            }
            // Target lesser than mid, search left space
            else if (target < midElement) {
                right = mid - 1;
            }
            // Target greater than mid, search right space
            else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
