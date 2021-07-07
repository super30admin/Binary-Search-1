// Time Complexity :
//		modBinSearch() - O(log(n))
//      
// Space Complexity :
//		modBinSearch() - O(1)
//
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No

class Problem2
{
	public static void main(String[] args)
	{
		int[] num = new int[]{1,3,5,7,8,9,10,11,13,14,15,16,17,18};
		int target = 14;

		System.out.println("Modified Binary Search(14) -> " + modBinSearch(num, target));
	}

	private static int modBinSearch(int[] nums, int target)
	{
		int l=0, h=1;

		while(h < nums.length && target >= nums[h])
		{
			l = h;
			h = 2*h;
		}

		while(l <= h)
		{
			int m = l + (h-l)/2;

			if(nums[m] == target)
				return m;
			else if(nums[m] < target)
				l = m+1;
			else
				h = m-1;
		}
		return -1;
	}
}