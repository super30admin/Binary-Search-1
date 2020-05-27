// Time Complexity : O(log t) where t is index of target
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Solution without using ArrayReader -  Accessing an element out of bounds throws exception

public class UnknownArray {
	
	
	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		int target = 2;
		
		if(nums[0]==target) {System.out.println("0"); System.exit(0);}
		
		int s=0;
		int e=1;
		
		try
		{
			int lastNum = nums[e];
			while(target>lastNum)
			{
				s=e;
				e = e*2;
				lastNum = nums[e];
			}
		}
		catch(Exception ex) {}
		
		while(s<=e)
        {
            int m = s + (e-s)/2;
            try {if(target==nums[m])  {System.out.println(m);System.exit(0);} } catch(Exception ex) {}
            
            try
            {
            	if(target<nums[m])
	            	e=m-1;
            	else
            		s = m+1;
            }
            catch(Exception ex)
	                {s=m+1;}
            	
        }
		
		
        System.out.println("-1");
		
		
	}
}
