// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :finding out the pivot point.


// Your code here along with comments explaining your approach

//first we will find out the pivot point in the array using the binary search.
//then we can do the binary search againt to find the index of the lement.
//based on whether the element lies to the left or right of the pivot

class Solution {
    public int search(int[] nums, int target) {
		int start=0;
		int end=nums.length-1;
		int midPoint=0;
		while(start<end) {
			midPoint=start+(end-start)/2;
			if(nums[midPoint]>nums[end]) {
				start=midPoint+1;
			}else {
				end=midPoint;
			}
		}
		// while(start<=end) {
		// 	midPoint=start+(end-start)/2;
		// 	if(nums[midPoint]>nums[start] && nums[midPoint]<nums[end]) {
		// 		break;
		// 	}else if(nums[midPoint]>nums[start]){
		// 		start=midPoint+1;
		// 	}else if(nums[midPoint]<nums[start]) {
		// 		end=midPoint-1;
		// 	}
		// }
		//System.out.println(start);
        if(nums[start]==target){
            return start;
        }
		int pivot=start;
		start=0;
		end=nums.length-1;
		if(target>=nums[pivot] && target<=nums[end]){
            start=pivot;
        }else{
            end=pivot;
        }
        while(start<=end){
            midPoint=start+(end-start)/2;
			if(nums[midPoint]<target){
                start=midPoint+1;
            }else if(nums[midPoint]>target){
                end=midPoint-1;
            }else{
                return midPoint;
            }
        }
        
        return -1;
        
    }
}