
// Time Complexity : O(log(n))
// Space Complexity : O(1)

public class SearchArrayUnknownSize {
	
	public int search(ArrayReader reader, int target) {
		
		int low =0;
		int high =1;
		
		//find the range of array to search the element
		while(target>reader.get(high)) {
			low = high;
			high = high*2;
		}
		
		//binary search
		while(low<=high) {
			int mid = low+(high-low)/2; //prevents integer overflow
			if(reader.get(mid)==target) {
				return mid;
			}
			else if(target<reader.get(mid)) {
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		return -1;
		
	}

}
