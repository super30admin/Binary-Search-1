package Default;

//Time Complexity : log n + log range
//Space Complexity : 
//Did this code successfully run on Leetcode : Not having leetcode premium but matched the code with video
//Any problem you faced while coding this : referred to video for understanding the end point
/*Search in Infinite sorted array:

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1. */

public class findUnknownSizeArray {

	public int search(ArrayReader reader, int target) {
		
		int l = 0;
		int h = 1;
		//Identify the searchspace where target will be less than the max value and lies in the range and then call for normal binary search in that space.
		//till high is not greater than target, increase it by 2x for maintaining the time complexity.
		while(reader.get(h) != Integer.MAX_VALUE && reader.get(h) < target) {
			
			l = h;
			h = 2 * h;
			
			
		}
		
		return BinarySearch(reader,target,l,h);

	}
	
	static int BinarySearch(ArrayReader reader,int target,int l,int h) {
		
		
		while(l <= h) {
		int mid = l + (h - l)/2;
		
		if(reader.get(mid) == target) {
			
			return mid;
		}
		
		else if(reader.get(mid) < target) {
			
			l = mid + 1;
			
		}
		
		else h = mid - 1;
	}
		return -1;
	}
}
