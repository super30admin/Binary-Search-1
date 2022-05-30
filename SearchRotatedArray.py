#33. Search in Rotated Sorted Array

"""
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
On observation it is found that at least one side of rotated array is sorted.
This can be used for binary search
"""


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1

        low = 0
        high = len(nums) - 1

        if nums[low] == target:
            return low

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                return mid

            # check if left side is sorted.
            elif nums[low] <= nums[mid]:
                #changing position of high if target is present in sorted side(left side).
                if nums[low] <= target and target < nums[mid]:
                    high = mid - 1

                # changing position of low if target is not present in sorted side(left side).
                else:
                    low = mid + 1

            #right side is sorted.
            else:
                # changing position of low if target is present in sorted side(right side).
                if target > nums[mid] and nums[high] >= target:
                    low = mid + 1

                # changing position of high if target is not present in sorted side(right side).
                else:
                    high = mid - 1

        return -1
