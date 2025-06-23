//Time O(log n)
//space O(1)
public class SearchUnknownSizeArray {

	public int search(ArrayReader reader, int target) {
        int index = 1;
        while (reader.get(index) < target) {
            index *= 2;
        }

        int left = index / 2;
        int right = index;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = reader.get(mid);

            if (val == target) {
                return mid;
            } else if (val > target || val == Integer.MAX_VALUE) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1; 
    }

}
