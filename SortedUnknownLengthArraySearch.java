// Time Complexity : O(log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

/**
 * 1. As we dont know the length of an array we can't do binary search. First we need to find upper bound for search. 
 * 2. start from lower 0 and upper 1 and find the target is below the upper bound.
 * 3. if not make upper  as lower and increase the upper bound at the exponential of 2.
 * 4. if any time target is between the elements range exist and do binary search as we know the lower and upper bound of an array.
 * 5. any time if it is out of bounds error reduce the upper to half and try till we find the end of an array.
 */

class solution2 {
	public int findPos(int target, int[] arr) {
		boolean done = false;
		int i = 1;
		int lower = 0;
		int upper = 1;
		int temp;
		while (!done) {
			try {
				if (target == arr[upper])
					return upper;
				else if (target > arr[upper]) {
					temp = lower;
					lower = upper;
					upper = temp + (int) Math.pow(2, i);
					i = i + 1;
				} else {
					done = true;
					break; // found the upper bound
				}
			} catch (IndexOutOfBoundsException e) {
				upper = (upper - lower) / 2;
				i = 0;
			}
		}
		if (done == true) {
			return binarySearch(target,arr,lower,upper);
		} else
			return -1;
	}
	
	public int binarySearch(int target, int[] arr,int l,int r) {
		while(l<=r) {
			int mid = l+(r-l)/2;
			
			if(arr[mid]==target) {
				return mid;
			}else if (arr[mid]<target) {
				return binarySearch(target, arr, mid+1, r);
			}else {
				return binarySearch(target, arr, l, mid-1);
			}
		}
		return -1;
	}

}

public class SortedUnknownLengthArraySearch {
	public static void main(String[] args) {
		
		int arr[] = new int[]{3, 5, 7, 9, 10, 90,
				100, 130, 140, 160, 170};
		
		System.out.println(new solution2().findPos(1, arr));
	}
}
