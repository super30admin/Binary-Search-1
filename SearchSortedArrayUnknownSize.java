package Day2;

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
//Time Complexity: O(log n)
// Since we are doing binary search by reducing search space by half.

// Space Complexity: O(1) 
// No extra space used.

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : 
// Difficulty in deciding the most suitable strategy to determine the range in the array for binary search

// If the array is infinite, that means we don’t have proper bounds to apply binary search. 
// So in order to find index of a target element, first fix the bounds and then apply binary search algorithm.
    
class SearchSortedArrayUnknownSize {
    public int search(ArrayReader reader, int target) {
        
        int start = 0;
		int end = 1;

		// Determining the range in the array in which the target element lies
		while (reader.get(end) < target) {	
			start = end;
			end = end * 2;
		}
		// Applying binary search on the array within the bounds identified in while loop just before
		return binarySearch(reader, target, start, end);
    }
    
    public static int binarySearch(ArrayReader reader, int target, int start, int end) {

    	// Applying binary search algorithm to find the target element in an array with given start and end index. 
		int mid = 0;

		while (start <= end) {
			mid = start + (end-start)/2;
			if (reader.get(mid) == target) {
                return mid;
			}
			else if (reader.get(mid) < target) {
				start = mid + 1;
			}  
			else {
				end =  mid - 1;
			}
		}
	    return -1;	
	} 
}