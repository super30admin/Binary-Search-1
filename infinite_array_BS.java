// time complexity = O(logn) - since binary search is used to compute it.
//space complexity = O(1) - except for constant space used there is no other space used.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// - Mid of array is computed. If target is equal to middle element mid is 
// returned as index
// - Check if the target is in the sorted or unsorted portion of the array.
// - If the target is in sorted portion, perform the binary search
// - If the target is in unsorted portion, the algorithm continues as above until 
// it finds the target in sorted portion and performs binary search.
// */

// Search in Infinite sorted array:

// Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.


class BSPROBLEM2{
	public int search(ArrayReader reader, int target){
	int low =0;
	int high = 1;
	while(target > reader.get(high){
		high = high*2;
	}
	return binarySearch(reader,low,high,target);
}

public int binarySearch(ArrayReader reader, int low, int high, int target){
	while(low <= high){
		if(target == reader.get(mid)) return mid;
		else {
			if(target < reader.get(mid)) return high = mid - 1;
			else low = mid+1;
		}
	}
	return -1;
}
}