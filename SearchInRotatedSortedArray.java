// First check if the element at lower index is lesser than mid, if yes, then perform binary search over this half
// Else perform binary search over the complete array
// Time complexity: O(log n)
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SearchInRotatedSortedArray {

	public int search(int[] A, int target) {
	    int lo = 0;
	    int hi = A.length - 1;
	    while (lo < hi) {
	        int mid = (lo + hi) / 2;
	        if (A[mid] == target) return mid;
	        
	        if (A[lo] <= A[mid]) {
	            if (target >= A[lo] && target < A[mid]) {
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        } else {
	            if (target > A[mid] && target <= A[hi]) {
	                lo = mid + 1;
	            } else {
	                hi = mid - 1;
	            }
	        }
	    }
	    return A[lo] == target ? lo : -1;
	}
	
	
	
}
