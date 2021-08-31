#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Aug 30 19:15:28 2021

@author: ameeshas11
"""

#Time Complexity : O(log n)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        #null
        if (len(nums)==0):
            return -1
        low = 0
        high = len(nums) - 1
        
        while high >= low:
            mid = (low + high)//2
            if nums[mid] == target:
                return mid
            if nums[low]<=nums[mid]:
                if nums[low]<= target and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid]< target and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
                    
        return -1
                
        