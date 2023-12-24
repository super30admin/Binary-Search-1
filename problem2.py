""" The approach uses binary search to return the index of the element when its found. To take care
    of the array rotation, we search for the target at the middle first, if that's not found, we check
    to see if the target can be right or left, since the array is sorted, we can make that decision.
    After picking the direction, I then do binary search on that part of the array until the target is found.
    Time Complexcity: O (log n)
    Space Complexcity: O(1)
"""


class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if(nums == None or len(nums) == 0):
            return -1
        low = 0
        high = len(nums) - 1
        while(low <= high):
            mid = low + (high - low)//2  # to avoid int overflow
            if(nums[mid] == target):
                return mid
            elif(nums[low] <= nums[mid]):
                if(nums[low] <= target and nums[mid] > target):
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if(nums[mid] < target and nums[high] >= target):
                    low = mid + 1
                else:
                    high = mid - 1
        return -1

        