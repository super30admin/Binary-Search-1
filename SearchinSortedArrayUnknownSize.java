//time complexity: O(n)
//space complexity: O(1)
// Did this code successfully run on Leetcode : DO not have premium account+

package BinarySearch1;

public class SearchinSortedArrayUnknownSize {
	public int serach(ArrayReader reader,  int target) {
		int low=0;
		int high=1;
		
		while(reader.get(high) < target) {
			low=high;
			high=high*2;
			
		}
		while(low <=high) {
			int mid = low+(high-low) /2; 
			
			if(reader.get(mid)== target) {
				return mid; 
			}else if(reader.get(mid)> target) {
				high = mid-1; 
			}else {
				low = mid+1; 
			}
		}
		return -1;
		
		
	}

}
