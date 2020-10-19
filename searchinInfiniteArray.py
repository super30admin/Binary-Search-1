#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Nov 20 08:34:41 2019

@author: tanvirkaur
"""
class Number(object):
    def search(self,nums,target):
        lo = 0
        high= 1
    
        while(nums[high]< target):
            lo = high
            high = high*2
        return self.binarysearch(nums,target,lo,high)

    def binaryserach(self,nums,target,l,h):
        if l > h:
            return -1
    
        mid = (l + h)//2
        if nums[mid] == target:
            return mid
    
    
        elif target > nums[mid]:
            l = mid+ 1
        else:
            h = mid-1
        return self.binarysearch(nums,target,l,h)
    
 
