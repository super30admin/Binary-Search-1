'''Approach:
Since one part of the array is always sorted, we need to compare the target element
with nums[low] and nums[high] for each iteration and update mid accordingly.
'''


# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # base case
        if not nums or len(nums) == 0:
            return -1

        low = 0
        high = len(nums) - 1

        while (low <= high):
            mid = low + (high - low) // 2  # To avoid integer overflow
            if nums[mid] == target:
                return mid

            # left side of the array is sorted
            if nums[low] <= nums[mid]:
                # when the target lies in the left side of the array, update high to mid-1, else low to mid+1
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1

                else:
                    low = mid + 1

            # right side of the array is sorted
            else:
                # when the target lies within the right side of the array, update low to mid+1, else high to mid-1
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1

                else:
                    high = mid - 1

        return -1

