"""
// Time Complexity : o(log n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : left side sorted and else statement made a mistake but managed to recover


// Your code here along with comments explaining your approach in three sentences only
split search space into 2 using mid element
if target found at mid return
if left side is sorted search there else if right side is sorted search there
in each sorted side check if target exists in the sorted side, if yes make hi or lo inclusive of range where target exists if not search other side
"""

from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        lo = 0
        hi = len(nums) - 1
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            if nums[mid] == target:
                return mid
            else:
                # left side is sorted
                if nums[lo] <= nums[mid]:
                    # if target lies in sorted space
                    if nums[lo] <= target < nums[mid]:
                        hi = mid - 1
                    else:
                        lo = mid + 1
                # right side is sorted
                else:
                    if nums[mid] < target <= nums[hi]:
                        lo = mid + 1
                    else:
                        hi = mid - 1

        return -1
