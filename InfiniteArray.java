public class InfiniteArray {

	public static int search(int arr[], int low, int high, int target) {
		if (arr == null || arr.length == 0)
			return -1;
		while (low <= high) {
			int middle = low + ((high - low) >> 1);
			if (arr[middle] == target)
				return middle;
			if (arr[middle] < target)
				low = middle + 1;
			else
				high = middle - 1;
		}
		return -1;
	}

	public static int search(int array[], int target) {
		int low = 0, high = 1;
		int val = array[low];
		while (val < target) {
			low = high;
			high = 2 * high;
			val = array[high];
		}
		return search(array, low, high, target);

	}
}
