// Time Complexity : O(logn)
// Space Complexity :O(mn)
class SortedArrayUnknownSize implements ArrayReader {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        while (reader.get(right) < target) {
            left = right;
            right = right * 2;
        }

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int num = reader.get(mid);
            if (num == target)
                return mid;
            if (num > target)
                right = mid - 1;
            else
                left = mid + 1;

        }
        return -1;

    }
}
