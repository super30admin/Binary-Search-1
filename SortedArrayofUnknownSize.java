//Time Complexity - O(log(fast*n)) or O(log(n))
//Space Complexity - O(1)
//Ran in Leetcode - Yes

interface ArrayReader {
	int get(int index);
}

class Solution1 {
	public int search(ArrayReader reader, int target) {
		int slow = 0;
		int fast = 1;
		if (reader.get(slow) == target)
			return slow;
		while (reader.get(fast) < target ) {
			slow = fast;
			fast = fast * 2;
		}
		// binary search
		int middle = 0;
		while (slow <= fast) {
			middle = slow + (fast - slow) / 2;
			if (reader.get(middle) == target)
				return middle;
			else if (target > reader.get(middle))
				slow = middle + 1;
			else
				fast = middle - 1;
		}
		return -1;

	}
}

public class SortedArrayofUnknownSize {

	public static void main(String[] args) {
		int[] secret = { -1, 0, 3, 5, 9, 12 };
		int target = 9;

		// Create an ArrayReader implementation to simulate an unknown-size array
		ArrayReader reader = new ArrayReader() {
			@Override
			public int get(int index) {
				if (index < secret.length) {
					return secret[index];
				} else {
					return Integer.MAX_VALUE; // Return a value indicating out of bounds
				}
			}
		};
		Solution1 object = new Solution1();
		int index = object.search(reader, target);
		System.out.println(index);
	}
}
