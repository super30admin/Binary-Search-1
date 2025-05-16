# Time Complexity  : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on LeetCode? : Yes
# Any problems you faced while coding this?   : Understanding the concept was challenging at first,
#                                               but once I grasped the logic, I was able to implement
#                                               the solution on my first attempt.

#Your code here along with comments explaining your approach in three sentences only

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        low = 0
        high = len(nums) - 1

        while low<=high:

            mid = low + (high - low)//2

            if nums[mid] == target:
                return mid

            if nums[low] < nums[mid]:
                if nums[low] <= target and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        
        return -1


        