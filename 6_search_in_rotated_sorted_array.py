// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :found difficulty in determinig if conditions.
// Your code here along with comments explaining your approach
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        high=len(nums)-1
        low=0
        if len(nums)==0: return -1
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target: return mid
//In this case we can say that the array is in asc order from low to mid. here if our target lies in this range we can just search left.           
            if nums[mid]>= nums[low]:
                if nums[low]<=target<nums[mid]:
                    high=mid-1
                else:
                    low=mid+1
//In the case we can say that right part from mid to high is in asc so that if our target lies in that range we can just search
//right part.                   
            else:
                if nums[mid]<target<=nums[high]:
                    low=mid+1
                else:
                    high=mid-1
        return -1 