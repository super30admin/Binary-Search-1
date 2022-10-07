# Time Complexity O(logn)
# Space Complexity O(1)
from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2
            print(mid)
            if target == nums[mid]:
                return mid

            elif nums[left] <= nums[mid]:
                if nums[left] <= target <= nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1

            else:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1

        return -1


c = Solution()
c.search([4, 5, 6, 7, 0, 1, 2], 0)
