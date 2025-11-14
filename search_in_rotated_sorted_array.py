"""
we check which half is sorted first, either of the half has to be sorted, to check we first see if nums[low] is less than nums at mid, which would mean left half is sorted

"""

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
            mid = low + (high - low) //2
            if nums[mid] == target:
                return mid
            #checking left side
            if nums[low] <= nums[mid]: #if true, left half is gauranteed sorted
                if (nums[low] <= target and nums[mid] > target):
                    high = mid -1
                else:
                    low = mid + 1
            else:
                if (nums[high] >= target and nums[mid] < target):
                    low = mid + 1
                else:
                    high = mid - 1
        return -1



                



