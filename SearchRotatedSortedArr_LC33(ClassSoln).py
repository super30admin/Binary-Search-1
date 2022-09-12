# Leetcode submission successful
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        # Logarithmic time needed so Binary Search. Space Complexity: O(1).
        lo = 0
        hi = len(nums) - 1

        while (lo <= hi):
            mid = lo + (hi - lo) / 2  # to prevent integer overflow
            if nums[mid] == target:
                return mid

            # right part sorted
            if nums[mid] <= nums[hi]:
                if nums[mid] < target <= nums[hi]:
                    lo = mid + 1
                else:
                    hi = mid - 1

            # left part sorted
            else:
                if nums[lo] <= target < nums[mid]:
                    hi = mid - 1
                else:
                    lo = mid + 1
        return -1