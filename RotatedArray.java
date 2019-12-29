import java.util.*;

public class RotatedArray {
	public static int search(int arr[], int low, int high, int target) {
		if (arr.length == 0 || arr == null)
			return -1;
		if (low > high)
			return -1;
		int mid = low + ((high - low) >> 1);
		if (arr[mid] == target)
			return mid;

		if (arr[low] <= arr[mid]) {
			if (target >= arr[low] && target <= arr[mid])
				return search(arr, low, mid - 1, target);
			return search(arr, mid + 1, high, target);
		} else {
			if (target >= arr[mid] && target <= arr[high])
				return search(arr, mid + 1, high, target);
			return search(arr, low, mid - 1, target);
		}

	}

	public static int search(int[] nums, int target) {
		return search(nums, 0, nums.length - 1, target);
	}
}