#Rotated sorted aray
# The two preceding approaches both comprise two steps:
#Perform a binary search to identify the pivot index.
#Conduct another binary search to locate the target value.

#Time Complexity=O(logn)
#Space Complexity =o(1)
# Did this code successfully run on Leetcode : yes 

from typing import List
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums==None or len(nums)==0:
            return -1
    
        n=len(nums)
        low=0
        high=n-1
        while low<=high:
            mid=low+(high-low)//2

            if target==nums[mid]:
                return mid
            if nums[low]<=nums[mid]:
                if target>=nums[low] and target<nums[mid]:
                    high=mid-1
                else:
                    low=mid+1
                if target>nums[mid] and target<=nums[high]:
                    low=mid+1
                else:
                    high=mid-1
            
        return -1
