# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start = 0
        end = len(nums) - 1

        while start <= end:
            mid = start + (end - start)//2
            if nums[mid] == target:
                return mid

            # search left sub array
            if nums[start] <= nums[mid]:
                if target >= nums[start] and target < nums[mid]:
                    end = mid - 1
                else:
                    start = mid + 1
            #  search right sub array
            else:
                if target < nums[start] and target > nums[mid]:
                    start = mid + 1
                else:
                    end = mid - 1
        return -1
