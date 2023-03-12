/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        //when array size is undefined we start with 1st and 2nd element and expand our search
		int low = 0;
		int high = 1;
	
    while(target>reader.get(high))  {
        low = high;
        high = 2*high;
    }
		while(low<= high)	{
			int mid = low + (high-low)/2;
			if(target == reader.get(mid)) return mid;
			else if (target> reader.get(mid))	{
				low = mid +1;
		}
            else
				high = mid-1;
			
		}
		return -1;
    }
}