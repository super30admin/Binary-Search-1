"""
Time Complexity : O(log n) since we are performing a modified form of binary search
Space Complexity : O(1) since we are not declaring anything. We are just finding the mid element and comparing
                   till we find the target element
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

"""

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        i = 0
        j = len(nums) - 1

        while i <= j:
            mid = (i+j) // 2

            if target == nums[mid]:
                return mid

            if nums[i] <= nums[mid]:
                if target < nums[mid] and target >= nums[i]:
                    j = mid - 1
                else:
                    i = mid + 1

            else:
                if target > nums[mid] and target <= nums[j]:
                    i = mid + 1
                else:
                    j = mid - 1

        return -1

