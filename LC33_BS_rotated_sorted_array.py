#  Time Complexity : O(log n)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : yes
#  Any problem you faced while coding this : No

# Approach: At each iteration, we identify the sorted half, check if the target lies in it, and discard the other half, reducing the search space by half.


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            # left sorted
            if nums[mid] == target:
                return mid
            if nums[low] <= nums[mid]:
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
