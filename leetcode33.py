#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb  8 15:20:40 2026

@author: rishigoswamy

    Approach:
    ----------
    The array is originally sorted in ascending order but rotated at an
    unknown pivot, which means that at least one half of the array is
    always sorted.
    
    Using binary search, we compare nums[low], nums[mid], and nums[high]
    to determine which half of the array is sorted at each step.
    
    If the left half is sorted, we check whether the target lies within
    that range; otherwise, we discard it and search the right half.
    If the right half is sorted, we perform the symmetric check and
    continue narrowing the search space accordingly.
    
    This approach maintains the logarithmic time complexity of binary search
    despite the rotation.
    
    Time Complexity:
    ----------------
    O(log n), where n is the number of elements in the array.
    
    Space Complexity:
    -----------------
    O(1), since the search is performed in-place using constant extra space.
    
    Did this code successfully run on Leetcode:
    ------------------------------------------
    Yes
    
    Any problem you faced while coding this:
    ---------------------------------------
    Carefully handling the boundary comparisons to correctly identify the
    sorted half and avoid infinite loops or missed target values.

"""

class Solution:
    def search(self, nums, target) -> int:
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = (low+high)//2
            if nums[mid] == target:
                return mid
            if nums[low] <= nums[mid]:
                if target >= nums[low] and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1 
