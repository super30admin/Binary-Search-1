package RotatedArray;

class Solution {
    public static int search(int[] nums,int target) {
    	int left = 0;
    	int right = nums.length-1;
    	
    	while(left<= right && left<nums.length &&  right>=0)
    	{
    		int mid = left +(right - left)/2;
    		
    		if(nums[mid] == target) {
    			return mid;
    			
    		}
    		
    		if(nums[left]<=target && nums[left]<=nums[mid] && target<=nums[mid])
    		{
    			right = mid;
    		}
    		
    		else if(nums[left]<=nums[mid])
    		{
    			left = mid+1;
    		}
    		
    		else if(nums[right]>= target && nums[right]>=nums[mid] & target>=nums[mid])
    		{
    			left = mid;
    		}
    		
    		else {
    			right = mid-1;
    		}
       
            
    }
		return -1;
    
    }    
  public static void main(String[] args) {
    
         int[] nums = {4,5,6,7,0,1,2};
         
        int obj =  search(nums,0);
        System.out.println(obj);
    }
    

}
























