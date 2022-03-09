# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# While performing binary search on the array, check if it has been rotated yet or not by checking if the low element
# of that subarray is lower than the mid element. If it has been rotated then check if target lies in between low and mid or high and mid.

from typing import List
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        lo,high=0,len(nums)-1

        while lo<=high:
            mid=(lo+high)//2

            if nums[mid]==target:
                return mid
            
            if nums[lo]<=nums[mid]:
                if nums[lo]<=target<=nums[mid]:
                    high=mid-1
                else:
                    lo=mid+1
            else:
                if nums[mid]<=target<=nums[high]:
                    lo=mid+1
                else:
                    high=mid-1

        return -1
            

obj=Solution()
print(obj.search([4,5,6,7,0,1,2],1))