//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : No access
//Any problem you faced while coding this : 

class Search_Number_UnknownArray {
	int index = -1;
	public int search(int[] nums, int target) {
		
		try {
			while(nums[index++] != target)
			{
				
			}
			return index--;
				
		} catch(Exception e) {
			System.out.println("IndexOutOfBoundsException: Array index out of bounf exception!");
		} 
			return index--;
			
	}
	
	public static void main(String[] args) { 
    	int[] nums = {0,1,2,4,5,6,7};
    	Solution sl = new Solution();
    	
    	System.out.println(sl.search(nums, 10));
	}
}
