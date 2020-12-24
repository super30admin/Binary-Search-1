public class SearchinaSortedArrayofUnknownSize {

	public int search(ArrayReader reader, int target) {

		int low = 0;
		int high = 1;

		while (reader.get(high) < Integer.MAX_VALUE && reader.get(high) < target) {
			low = high + 1;
			high = high * 2;
		}

		while (low <= high) {

			int mid = low + (high - low) / 2;

			if (reader.get(mid) == target)
				return mid;

			else if (reader.get(mid) > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;

	}

}