# Using Binary search to get the Target element
# TC: O(log n) we are able to divide the input in in half each time hence the TC
# SC: O(1) no extra space getting used

from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        low, high = 0, n - 1

        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:  # if mid is the target
                return mid
            if nums[low] <= nums[mid]:  # if low < mid then search in left sorted part
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target <= nums[high]:  # search in right sorted part
                    low = mid + 1
                else:
                    high = mid - 1
        return -1


obj = Solution()
nums = [4, 5, 6, 7, 0, 1, 2]
target = 0
print(obj.search(nums, target))
