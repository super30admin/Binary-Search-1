# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : messed up in figuring out the left sorted array


# Your code here along with comments explaining your approach in three sentences only
# We use binary search to find the target in the rotated sorted array.
# At each step, we check which side (left or right) is sorted and then move search boundaries accordingly.
# This ensures we keep halving the search space until we either find the target or return -1.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0 # left boundary
        r = len(nums) - 1 # right boundary

        while l <= r: # continue until pointers cross
            mid = (l + r)//2 # calculate middle index

            if nums[mid] == target: # found the target
                return mid
            # Check if left half is sorted
            if nums[l] <= nums[mid]:
                # target lies within left half
                if nums[l] <= target < nums[mid]:
                    r = mid - 1
                else: # target lies in right half
                    l = mid + 1
            # Otherwise, right half must be sorted
            elif nums[mid] < target <= nums[r]:
                l = mid + 1 # target is in the right half
            else:
                r = mid - 1  # target is in the left half

        return -1