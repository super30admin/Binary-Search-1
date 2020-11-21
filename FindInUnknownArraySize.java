// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : didnt get the idea of multipying it by to 2 to find the element
class Solution {
    public int search(ArrayReader reader, int target) {
		int low = 0; high=1;
        while(target>reader.get(high){
			low=high;
			high=2*high;
    }
	while(low<=high){
		int mid= low+(high-low)/2;
		if(target==reader.get(mid);
			return mid;
		if(target>reader.get(mid))
			low=mid+1;
		else
			high=mid-1;
	}
	return -1;
}}