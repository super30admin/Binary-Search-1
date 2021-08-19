// TIME: O(logn)
// SPACE: O(1)
// SUCCESS on LeetCode

public class SearchSecretArray {
    // Checking the start and end bounds by doubling the end pointer if the target is greater than the end.
    // Once the bounds are set, then used binary search to find the target element. 
    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 1;
        while (target > reader.get(end)) {
            end = end * 2;
        } 
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == reader.get(mid)) return mid;
            if (target > reader.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1; 
            }
        }
        return -1;
    }
}
