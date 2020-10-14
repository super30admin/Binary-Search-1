//Time Complexity : O(logn)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : 

class Solution {
    int index = -1;
	
	boolean binarySearch(int firstIndex, int lastIndex, int[] nums, int target)
    {
		if (nums[firstIndex] == target)
        {
        	index = firstIndex;
        	return true;
        }
		
		else if (nums[lastIndex] == target)
        {
        	index = lastIndex;
        	return true;
        }
		
		else if(lastIndex - firstIndex == 0)
        {
        	if (nums[0] == target)
        	{
        		index = 0;
        		return true;
        	}
        	return false;
        }
        
        int midValue = (lastIndex + firstIndex) / 2;
        
        if(nums[midValue] == target)
        {
        	index = midValue;
        	return true;
        }
        
        else
        {
        	if(binarySearch(firstIndex, midValue, nums, target) || binarySearch(midValue+1, lastIndex, nums, target))
        		return true;
        return false;
        }
        		
    }
    
    public int search(int[] nums, int target) {
        
        if(binarySearch(0, nums.length-1, nums, target))
            return index;
        return -1;
    }
    
    public static void main(String[] args) { 
    	int[] nums = {4,5,6,7,0,1,2};
    	Solution sl = new Solution();
    	
    	System.out.println(sl.search(nums, 0));
    	System.out.println(sl.search(nums, 3));
    	
    }
}