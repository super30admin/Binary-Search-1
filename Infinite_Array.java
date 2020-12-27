// Time Complexity : log(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : I dont have premium leetcode but I tested and it worked
// Any problem you faced while coding this : It was a pretty simple solution, but the solution approach was new to me


// Your code here along with comments explaining your approach
public class Infinite_Array{

	public int search(ArrayReader reader, int target) {
		int low = 0;
		int high = 1;
		while(reader.get(high) < Integer.MAX_VALUE && reader.get(high) < target){
			low = high;
			high = 2*high;
		}

		//do binary search
		while(low <= high){
			int mid = low + (high - low)/2;

			if(reader.get(mid) == target){
				return mid;
			}
			else if(reader.get(mid) > target){ //its on the left side
				high = mid - 1;
			}
			else{
				low = mid + 1;
			}
		}
		return -1;
	}
	
}



