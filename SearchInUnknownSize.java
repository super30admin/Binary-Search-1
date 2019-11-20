//time complexity : (logn+ logn) ~ (2logn) ~ O(logn)
//space complexity : O(1) , we are not using any extra space neither recursion

public class SearchInUnknownSize {

	public int searchElement(int[] nums, int target)
	{
		int l=0;
		int h=nums.length-1;
		
		while(l<=h)
		{
			int mid=(l+(h-l)/2); 
			if(target==nums[mid]) 
				return mid;
			
			if(target<nums[mid])
			{
				h=mid-1;
			}
			else
			{
				l=mid+1;
			}
		}
		
		while(target>h)
		{
			l=h;
			h=h*2;
			
		}
		return -1;
		
	}
	
	public static void main(String[]  arg)
	{
		SearchInUnknownSize s= new SearchInUnknownSize();
		int[] nums= {1,2,3,4,5,6,7,8,9,10,15,18,20};
		int index= s.searchElement(nums,18);
		
		if(index==-1)
		{
			System.out.println("element doesn't exist");
		}
		else
		{
			System.out.println("element found at index: "+index);
		}
	}
}
