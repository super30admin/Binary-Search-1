public class searchInSortedArrUnknownSize {
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int h = 1;

        while (reader.get(h) < target) {
            l = h;
            h = h * 2;
        }

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (reader.get(m) == target)
                return m;
            else if (reader.get(m) > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
