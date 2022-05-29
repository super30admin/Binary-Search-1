class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0, r = Integer.MAX_VALUE;
        if (reader.get(r) < target)
            return Integer.MAX_VALUE;

        while (l < r) {
            int mid = (l + r) / 2;
            if (reader.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return reader.get(l) == target ? l : -1;
    }
}