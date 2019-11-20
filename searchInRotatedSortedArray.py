#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Nov 20 08:46:55 2019

@author: tanvirkaur
"""

#Time complexity = O(logn)
#Space complexity = O(1)


class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        lo = 0
        high = len(nums)-1
        while lo <= high:
            mid = (lo+high)//2
            if nums[mid] == target:
                return mid
            elif nums[lo] <= nums[mid]:
                if target >= nums[lo] and target < nums[mid]:
                    high = mid-1
                else:
                    lo = mid +1
            else:
                if target >= nums[mid] and target <= nums[high]:
                    lo = mid+1
                else:
                    high = mid-1
        return -1        