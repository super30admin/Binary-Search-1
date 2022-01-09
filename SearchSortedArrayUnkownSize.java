//Time: O(log n)
//Space: O(1)
class Solution {
    public int search(ArrayReader reader, int target) {
       int start = 0;
	   int end = 1;
	   
	   //Find the range or eliminate the rest of the state space
	   while(reader.get(end) >= target && reader.get(end) < Integer.MAX_VALUE) {
			start = end;
			end = 2 * end; 
	   }
	   
	   //BS
	   while(start <= end) {
			int mid = (start + end)/2;
			if(reader.get(mid) == target) {
				return mid;
			}
			
			if(reader.get(mid) < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
	   }
	   
	   return -1;
    }
}