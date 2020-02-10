/*

Time Complexity: O(logN), where N is the size of the infinite sorted array 
Space Complexity: O(1)

Explanation: To apply binary search, we use function findLengthRange to find the upper bound of the range that encompasses target. 
Since, it is an infinite array, we keep on the increasing the high by it's double, that means we increase double our jump at every step. 
this gives us O(logN) + binarySearch of O(logN)

*/


public class sol {


public static int findLengthRange (int [ ] a, int target) {
	int low = 0 ; 
	int high = 1 ; 
	while (a[h] < target) {
		low = high ; 
		high = 2 * high ; 
	}

	return high ; 
}

public static int bs (int [] a , int l , int h , int target) {
	int l = 0 ;
	int h = h ; 
	while (l <= h) {
		int m = l + (h - l) / 2 ; 
		if (a[m] == target) return m ; 
		if (a[m] > target) h = mid - 1 ; 
		else if (a[m] < target) l = mid + 1 ; 
	}

	return -1 ; 

	}
}




}