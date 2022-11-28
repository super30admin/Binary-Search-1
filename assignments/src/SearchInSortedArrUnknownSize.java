public class SearchInSortedArrUnknownSize {
    public int search(ArrayReader reader, int target) {

        int n =0;
        while(reader.get(n) != Integer.MAX_VALUE) {
            n++;
        }

        int left = 0;
        int right = n-1;
        int pivot = 0;

        while (left <= right) {
            pivot = left + (right-left)/2;
            if (reader.get(pivot) == target) return pivot;
            if (reader.get(pivot) < target) {
                left = pivot + 1;
            }
            else {
                right = pivot -1;
            }
        }
        return -1;
    }
}