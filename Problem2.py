# Time Complexity: O(logn)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: all test cases passed
# Any problem you faced while coding this: No

# Approach: Figure out is the target on the first increasing or second increasing subsequence.
# 2.Decide change right or left

class Solution(object):
    def search(self, nums, target):
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) >> 1
            if nums[mid] == target:
                return mid
            if target >= nums[0]:
                if nums[mid] < target and nums[mid] >= nums[0]:
                    left = mid + 1
                else:
                    right = mid - 1
            else:
                if nums[mid] < target or nums[mid] >= nums[0]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1