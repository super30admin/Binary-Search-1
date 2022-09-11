class Solution{
	public int search(ArrayReader reader,int target)
	{
		int l=0;
		int h=1;
		while(reader.get(h)<=target)
		{
			l=h;
			h*=2;
		}


		return binarySearch( reader, target, l, h);
	}

	private int binarySearch(ArrayReader reader,int target,int l,int h)
	{
		while(l<=h)
		{
			int m=l+(h-l)/2;
			int val=reader.get(m);
			if(val==target)
				return m;
			else if(val<target)
				l=m+1;
			else 
				h=m-1;
		}
		return -1;
	}
}


// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : premium problem