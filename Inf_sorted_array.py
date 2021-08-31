#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Aug 30 19:18:52 2021

@author: ameeshas11
"""
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low = 0
        high = 1
        
        while(reader.get(high) < target):
            low = high + 1
            high = high*2
        
        while high>=low:
            mid = (low+high)//2
            if(reader.get(mid) == target):
                return mid
            elif reader.get(mid) > target:
                high = mid-1
            else:
                low = mid+1
        return -1
        
   