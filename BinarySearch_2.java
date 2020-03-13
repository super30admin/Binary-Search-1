// Time Complexity : 2*O(logn) which is O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not in leetcode
// Any problem you faced while coding this : Was stuck in how to approach the problem, so referenced a solution


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int start, int end int target) {
        if(start<=end){
        int mid = start + (end - start)/2;
            
            if(nums[mid] == target)
                return mid;
            
            if(nums[mid]<target){
                search(nums,mid+1,end,target);
            }
            else{
                search(nums,start,mid-1,target);
            }
        }
        return -1;
    }
	
	public int findPosition(int nums[], int target){
		int start = 0;
		int end = 1;
		int value = nums[0];
		
		while(value<target){
			start = end;
			//to avoid array out of bounds exception
			if(2*end > nums.length-1){
				end = 2*end;
			}
			else{
				end = nums.length -1;
			}
			value = nums[end];
		}		
		return search(nums,start,end,target);		
	}
}