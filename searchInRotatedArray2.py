#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Nov 20 08:56:29 2019

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
        if not nums:
            return -1
        return self.helper(nums, target,0,len(nums)-1)
        
        
    def helper(self,nums,target,lo, high):
        #base case
        if lo > high:
            return -1
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
        return self.helper(nums, target, lo, high)
               