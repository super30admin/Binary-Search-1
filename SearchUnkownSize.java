//Time Complexity : O(log n)
//Space Complexity : O(1)

class Solution {
    public int search(ArrayReader reader, int target) {
	int low=0,high=1;
	while(reader.get(high)<target)
	{
		low=high;
		high=2*high;
	}
	while(low<=high)
	{
		int mid=low+(high-low)/2;
		if(target==reader.get(mid)) return mid;
		else if(target>reader.get(mid)) 
		{
			low=mid+1;
		}
		else
		{
			high=mid-1;
		}
	}
	return -1;
	
	
	
	}
}