// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No Problems faced

class Problem3{
	public int search(ArrayReader reader, int target) {
		int hi = 1;
		while(reader.get(hi)< target) {
			hi = hi<<1; // left shift operator is equivalent of *2
		}
		//Our range is now lo - hi, where lo= hi/2
		int lo = hi>>1;
		//normal binary search
		while(lo<=hi) {
			int mid = low + (hi-lo)/2;
			if(reader.get(mid) == target) {
				return mid;
			}else if(reader.get(mid)> target) {
				hi = mid -1;
			}else {
				lo = mid+1;
			}
		}
		return -1;
	}
	
}