package binarySearch1;

public class SearchInASortedArrayOfUnknownSize {
	// Time Complexity : O(log n)
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : Deciding the right(higher) bound for binary search
	public int search(ArrayReader reader, int target) {
        int left = 0, right = 3;
        while(target > reader.get(right)) {
            left = right + 1;
            right *= 2;
        }
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target == reader.get(mid))
                return mid;
            else if(target < reader.get(mid))
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return -1;
    }
}
