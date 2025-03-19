# Time Complexity : O(log2 n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List
def search(self, nums: List[int], target: int) -> int:
        n = len(nums)-1
        low = 0
        high = n
        while low <= high:
            mid = low+(high-low)//2
            if nums[mid] == target: 
                return mid
            elif nums[low]<= nums[mid]: # left sorted Array
               if nums[low] <= target and nums[mid] > target:
                  high = mid-1
               else:
                low = mid+1
            else: # right sorted Array
                if nums[mid]< target and nums[high] >= target:
                    low = mid+1
                else:
                    high = mid -1
        return -1