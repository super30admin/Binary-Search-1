// Time Complexity : o(log(m) + log(n)) //log m is for expansion phase,
// Space Complexity : o (1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
// as array size is unknown start with two pointer approach with low as zero and high as 1
// and keep doubling the size of high until the target is greater than the high value, this makes sure loop stops when target<high
// once range is identfied perform binay search to check if the target is inside or not 

public class SearchInSortedArrayOfUnknownSize {

	public int search(ArrayReader reader, int target) {
		// [-1,0,3,5,9,12] 9
		int low = 0;
		int high = 1;

		while (target > reader.get(high)) {
			low = high + 1;
			high = 2 * high;
		}

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (reader.get(mid) == target)
				return mid;
			else if (reader.get(mid) < target)
				low = mid + 1;
			else if (reader.get(mid) > target)
				high = mid - 1;
		}
		return -1;
	}
}
