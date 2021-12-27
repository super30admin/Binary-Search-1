interface ArrayReader {
    public int get(int index);
}

// TC O(logN) SC O(1).
public class UnknownSize {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == reader.get(mid)) {
                return mid;
            } else if (reader.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
