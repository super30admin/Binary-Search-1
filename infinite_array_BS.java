// time complexity = O(logn) - since binary search is used to compute it.
//space complexity = O(1) - except for constant space used there is no other space used.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No




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