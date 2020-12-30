// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : don't have leetcode premium
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution{
	public int search(ArrayReader reader, int target){
		int l = 0; int h = 1;
		while(reader.get(h) < Integer.MAX_VALUE && reader.get(high) < target){
			int l = h;
			int h = h*2;			
		}
		while(l <= h){
			int mid = l + (h-l)/2;
			if(reader.get(mid) == target){
				return mid;
			}
			else if (reader.get(mid) > target){
				int h = mid - 1;
			}
			else{
				int l = h + 1;
			}
		}
		return -1;
	}

}