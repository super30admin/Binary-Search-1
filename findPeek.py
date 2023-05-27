from typing import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        h = len(nums) - 1

        while l < h:
            mid = (h-l) // 2 + l
            if nums[mid] > nums[mid+1]:
                h = mid
            else:
                l = mid + 1

        return l 