# https://leetcode.com/problems/search-in-rotated-sorted-array/
# Time Complexity O(log(n))
# Space Complexity O(1)


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                return mid
            # left sorted
            if nums[low] <= nums[mid]:
                # nums[low] <= target < nums[mid] indicates target could be in the left half
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            # right sorted
            else:
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
