# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1
        low = 0
        high = len(nums)-1

        while high >= low:
            mid = (low + high) // 2 
            if nums[mid] == target: #if mid is equal to target return mid
                return mid
            if nums[low] <= nums[mid]: #if value of low less than or equal to the mid value
                if nums[low] <= target and target < nums[mid]: #if low value is less than target value and target value less than mid
                    high = mid - 1 #check on the left side 
                else:
                    low = mid + 1#else on the right side

            else: 
                if nums[mid] < target and target <= nums[high]: #if mid value is less than target value and target value less than high
                    low = mid + 1 #check on to the right side
                else:
                    high = mid - 1 #else on the left side

        return -1
