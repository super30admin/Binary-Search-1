'''
1. Check which part is sorted
2. The check if target lies in that sorted part. If not, check the target
in another part(unsorted one).
3. Apply Binary Search to keep track of the low and high indexes to find the element.
Applied Binary Search to keep track of the in
Time Complexity : O(logN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No.
'''

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2

            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[high] >= target and nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1



