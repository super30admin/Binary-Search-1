# -*- coding: utf-8 -*-
"""
Created on Sat Feb  5 17:29:08 2022

@author: BJay
"""
#Time Complexity : O(log(n))
#Space Complexity : O(1)
#Get through all test cases
#I got stuck for case of [3,1],1, though solved it
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        
        while low<=high:
            #get the mid
            mid = low + (high-low)//2
            
            #check if mid is the target
            if nums[mid] == target:
                return mid
            if nums[mid] < nums[high]:
                
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
                
            else:
                if target >= nums[low] and target < nums[mid]:
                    high = mid-1
                else:
                    low = mid+1
        return -1
        
