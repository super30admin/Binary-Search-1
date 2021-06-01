# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def search(self, nums: List[int], target: int) -> int:

        low = 0
        high = len(nums) - 1

        while low < high:
            mid = low + (high - low) // 2

            if nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid

        st = low
        low = 0
        high = len(nums) - 1

        if target >= nums[st] and target <= nums[high]:
            low = st
        else:
            high = st

        while (low <= high):
            mid = low + (high - low) // 2

            if target == nums[mid]:
                return mid
            if target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1

        return -1

