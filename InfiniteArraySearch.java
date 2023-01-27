/*
 * Author: Shubhangi
 * Time Complexity: O(max(m,n))
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : I was slightly confused with why we were doubling up the size by 2 and not by 3.
 * Please note: For testing purposes, I have removed ArrayReader API and added nums instead.
 * Explanation: I have taken start as 0 and as 1 and then till the target is greater than number at end index,
 * we will keep doubling the range we are checking. as soon as the target lies within that range, we will run our 
 * normal binarySearch program and take the mid b/w start and end and look for target.
 */

 class Solution {
    public static void main(String args[]) {
        //imagine this to be an infinite array
        int[] nums = {2,3,5,6,7,8,10,12,16,18,19,39,50,55};
        int target = 16;
        Solution obj = new Solution();
        System.out.println(obj.search(nums, target));
    }
    public int search(int nums[], int target) {
      if(nums == null || nums.length <=1 ){
            return -1;
        }
	  int start = 0, end = 1;
	  while(target > nums[end]){
		  int tempStart = end + 1;
		  end = start + (end - start + 1) * 2;
		  start = tempStart;
	  }
		return binarySearch(nums, target, start, end);
		}

		public int binarySearch(int nums[], int target, int start, int end){
				while(start <= end){
					int mid = start + (end - start)/2;
					if(nums[mid] == target){
						return mid;
					} else if(target < nums[mid]){
						end = mid -1;
					} else {
						start = mid +1;
					}
				} 
				return -1;		
				}
			}