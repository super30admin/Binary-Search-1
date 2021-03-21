# Time Complexity : O(log n) where n is the size of input array
# Space Complexity : O(n) where n = size of input array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, when low, high and mid were at the same point,
# the while loop was going into infinite loop. But figured out later.
#
#
# Your code here along with comments explaining your approach
from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while (low <= high):
            mid = (low + high) // 2
            if nums[mid] == target:
                return mid
            if mid + 1 <= len(nums) - 1 and nums[mid + 1] <= nums[high]:
                # check if sorted right side
                if nums[mid + 1] <= target <= nums[high]:
                    # check if target lies in sorted part
                    low = mid + 1
                else:
                    high = mid - 1
            else:
                # left is sorted
                if (mid - 1 >= 0):
                    # check if target lies in sorted part
                    if nums[low] <= target <= nums[mid - 1]:
                        high = mid - 1
                    else:
                        low = mid + 1
                else:
                    return -1
        return -1
