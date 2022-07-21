// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
	public int search(ArrayReader reader, int target) {
		int start = 0, end = 1;

		// stream the array such that the target lies between some interval [start, end]
		while (reader.get(end) < target) {
			start = end;
			end *= 2;
		}

		// once we get the next immediate highest boundary, apply binary search to part
		// of the array between those indices
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (reader.get(mid) == target)
				return mid;
			else if (reader.get(mid) < target)
				start = mid + 1;
			else
				end = mid - 1;
		}

		return -1;
	}
}