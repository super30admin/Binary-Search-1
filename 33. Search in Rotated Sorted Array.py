# Time Complexity : O(log n)
# Space Complexity :O(1) we only use low high and mid
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = low + (high - low)/2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                # left side sorted
                if nums[low] <= target and target < nums[mid]:
                    # target lies on left
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                # right side sorted
                if nums[high] >= target and nums[mid] < target:
                    # target lies on right
                    low = mid +1
                else:
                    high = mid - 1
        return -1