# Time Complexity: O(log(n))
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        r = (len(nums) - 1)
        i = 0
        while i <= r:
            x = ((i + r) // 2)
            if nums[x] == target:
                return x
            if nums[i] <= nums[x]:
                if nums[i] <= target < nums[x]:
                    r = (x - 1)
                else:
                    i = (x + 1)
            else:
                if nums[x] < target <= nums[r]:
                    i = (x + 1)
                else:
                    r = (x - 1)
        return -1