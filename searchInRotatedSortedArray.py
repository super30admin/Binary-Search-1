"""Iterative approach"""
#Accepted on Leetcode
#Time complexity - O(logN) as we are using binary search
#Space complexity - O(1) as we do not use any extra space

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        #Edge case
        if nums == None or len(nums) == 0:
            return -1
        start = 0 
        end = len(nums)-1
        while start <= end:
            mid = (start + end)/2
            if nums[mid] == target:
                return mid
            elif nums[start] <= nums[mid]:
                if nums[start] <= target and nums[mid] >= target:
                    end = mid - 1
                else:
                    start = mid + 1
            else:
                if nums[end] >= target and nums[mid] <= target:
                    start = mid + 1
                else:
                    end = mid -1
        return -1