// Time Complexity : O(log n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : premium required.
// Any problem you faced while coding this : No


public class infiniteArray {
	public int search(ArrayReader reader, int target) {
		int l = 0;
		int h = 1;
		while (reader.get(h) >= target) {
			if (reader.get(h) == target) {
				return h;
			}
			l = h;
			h = h * 2;
		}

		while (l < h) {
			int mid = l + (h - l) / 2;
			if (reader.get(mid) == target) {
				return mid;
			}
			if (reader.get(mid) > target) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}

		}
		return -1;
	}

}
