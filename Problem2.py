# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
from typing import List

class Solution:
    def search(self, nums: List[int], target: int)->int:
        if nums is None or len(nums)==0:
            return -1

        low = 0
        high = len(nums)-1

        while(low<=high):
            mid = low + (high - low)//2

            if nums[mid]==target:
                return mid
            elif(nums[low]<=nums[mid]):
                if(nums[low]<=target and nums[mid]>target):
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if(nums[high]>=target and nums[mid]<target):
                    low = mid + 1
                else:
                    high = mid - 1
        
        return -1

sc = Solution()
nums = [4,5,6,7,0,1,2]
target = 0
print(sc.search(nums, target))