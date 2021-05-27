// Time Complexity : O(log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

/**
 * 1. As we dont know the length of an array we can't do binary search. First we
 * need to find upper bound for search. 2. start from lower 0 and upper 1 and
 * find the target is below the upper bound. 3. if not make upper as lower and
 * increase the upper bound at the exponential of 2. 4. if any time target is
 * between the elements range exist and do binary search as we know the lower
 * and upper bound of an array. 5. any time if it is out of bounds error reduce
 * the upper to half and try till we find the end of an array.
 */

interface ArrayReader {
	public int get(int index);
}

class ArrayReaderImpl implements ArrayReader {
	int[] arr;
	public ArrayReaderImpl(int[] arr) {
		this.arr= arr;
	}
	public int get(int index) {
		if(index < arr.length) {
			return arr[index];
		}else {
			return 2147483647;
		}
	}
}

class solution2 {
	public int search(ArrayReader reader, int target) {
		if (reader.get(0) == target)
			return 0;

		// search boundaries
		int left = 0, right = 1;
		while (reader.get(right) < target) {
			left = right;
			right = right * 2;
		}

		return binarySearch(target, reader, left, right);
	}

	public int binarySearch(int target, ArrayReader reader, int l, int r) {
		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (reader.get(mid) == target) {
				return mid;
			} else if (reader.get(mid) < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

}

public class SortedUnknownLengthArraySearch {
	public static void main(String[] args) {

		int arr[] = new int[] { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };

		System.out.println(new solution2().search(new ArrayReaderImpl(arr),100));
	}
}
