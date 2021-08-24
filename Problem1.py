# -*- coding: utf-8 -*-
"""
Created on Mon Aug 23 12:31:32 2021

@author: User
"""

class Solution(object):
    def search(self, nums, target):
        if(len(nums)==0):
            return -1
            low=0
            high=len(nums)-1
            while(low<=high):
                mid=int(low+(high-low)/2)
                if(nums[mid]==target):
                    return mid
                elif(nums[low]<=nums[mid]):
                    if(nums[low]<=target and nums[mid]>target):
                        high=mid-1
                    else:
                        low=mid+1
                else:
                    if(nums[mid]<target and nums[high]>=target):
                        low=mid+1
                    else:
                        high=mid-1
            return -1
        