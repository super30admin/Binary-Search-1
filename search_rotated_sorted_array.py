# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
#
# Approach (3 sentences only):
#

from typing import Callable, Dict, Iterator, List, Optional, Tuple


class Solution:

    def search(self, nums: List[int], target: int) -> int:

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                return mid
            
            # left sorted
            elif nums[low] <= nums[mid]:
                if nums[low] <= target and target <= nums[mid]:
                    high = mid -1
                else:
                    low = mid + 1
            # right sorted
            else:
                if nums[mid] < target and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1
