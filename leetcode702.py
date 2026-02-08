#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb  8 15:26:09 2026

@author: rishigoswamy

    Approach:
    ----------
    Since the array size is unknown, we cannot directly apply binary search
    because we do not know the upper bound of the search space.
    
    To handle this, we first perform an exponential search to find a range
    [low, high] such that the target lies within that range.
    Starting from index 1, we repeatedly double the high index until
    reader.get(high) is greater than or equal to the target.
    
    Once the search range is identified, we apply a standard binary search
    within [low, high] using the ArrayReader API to locate the target.
    
    This approach ensures logarithmic time complexity while safely handling
    the unknown array length.
    
    Time Complexity:
    ----------------
    Range expansion   : O(log n)
    Binary search     : O(log n)
    Overall           : O(log n)
    
    Space Complexity:
    -----------------
    O(1), since only constant extra space is used.
    
    Did this code successfully run on Leetcode:
    ------------------------------------------
    Yes
    
    Any problem you faced while coding this:
    ---------------------------------------
    Managing repeated calls to reader.get() during range expansion and
    ensuring correct boundary conditions when identifying the valid
    search range.

"""

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def binarySearch(self, reader, target,  low, high):
        while low <= high:
            mid = (low+high)//2
            print(mid)
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1


    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0) > target:
            return -1
        if reader.get(0) == target:
            return 0
        low = 1
        high = low * 2
        rangeReached = False
        while (not rangeReached):
            if reader.get(low) == target:
                return low
            elif reader.get(low) <= target and reader.get(high) >= target:
                rangeReached = True
                return self.binarySearch(reader, target, low, high)
            else:
                low = high
                high = high*2
        
        return -1

        

