/**
 * Search In A Sorted Array Of UnknownSize
 * 1. As the size is unknown we don't know the bounds to do Binary search.
 * 2. In this algorithm, instead of reducing search space by half, we increase the search space by twice.
 * 3. Increase the search space by twice till we find our bounds and then binary search.
 */

class SearchInSortedArrayOfUnknownSize {

    interface ArrayReader {
        public int get(int index);
    }

    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 1;

        //Find the bounds where our target value can be found.
        while (reader.get(end) < target) {
            start = end;
            end = 2 * end;
        }

        //Do the binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target) return mid;
            else if (reader.get(mid) > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}