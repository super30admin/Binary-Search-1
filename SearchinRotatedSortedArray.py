# -*- coding: utf-8 -*-
"""
Created on Wed Feb  5 11:19:59 2020

@author: WELCOME
"""
"""
Working on Leetcode
Search in rotated sorted array
Time - O(logN)
Space - O(1)
"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=(low+high)//2
            if nums[mid]==target:
                return mid
            elif nums[low]<=nums[mid]:
                if target>=nums[low] and target<nums[mid]:
                    high=mid-1
                else:
                    low=mid+1
            else:
                if target<=nums[high] and target>nums[mid]:
                    low=mid+1
                else:
                    high=mid-1
        return -1
    