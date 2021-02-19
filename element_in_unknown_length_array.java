// Time Complexity : O(logn) to find high and O(logn) to find element in binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : Yes, Incrementing low pointer didn't come to my mind, Also My initial code was to handle array out of bounds exception
//But leetcode handles that by return INTEGER.MAX_VALUE which later was used in while loop for finding high


// Your code here along with comments explaining your approach

class Solution{
	
	public int search(ArrayReader reader, int target){
		int high=1;
		int low=0;
		
		while(reader.get(high)!=INTEGER.MAX_VALUE && reader.get(high)<=target){
			// We mutiply high pointer by 2 until we find a value greater than target at index high
			high=high*2;
			// We increment low pointer by 1 which can reduce the search space even more
			low=low+1;
		}
		// binary search to get the element
		return binarySearch(reader, low,high, target)
	}
	
	private int binarySearch(ArrayReader reader, int low, int high, int target){
		while(low<=high){
			int mid = low+(high-low)/2;
			
			if(reader.get(mid)==target){
				return mid;
			}
			
			else if(reader.get(mid)>target){
				high=mid -1;
			}
			else{
				low=mid+1;
			}
		}
		return -1;
	}
}
