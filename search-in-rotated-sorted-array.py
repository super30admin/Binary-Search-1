# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:

            mid = low + (high - low) // 2

            if nums[mid] == target:
                return mid

            if nums[low] <= nums[mid]:
                if nums[low] <= target <= nums[mid]:
                    high = mid
                else:
                    low = mid + 1
            else:
                if nums[mid + 1] <= target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid
        return -1
