#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb  8 15:17:01 2026

@author: rishigoswamy

    Approach:
    ----------
    Since the matrix has the property that:
    - Each row is sorted in ascending order, and
    - The first element of a row is greater than the last element of the previous row,
    
    we can treat the matrix as a two-level search problem.
    
    First, we apply binary search on the rows to find the single row
    whose value range may contain the target (i.e., target lies between
    the first and last elements of that row).
    
    Once the candidate row is identified, we perform a second binary search
    within that row to determine whether the target exists.
    
    This reduces the overall search space efficiently using binary search
    at both levels.
    
    Time Complexity:
    ----------------
    Row binary search    : O(log m)
    Column binary search : O(log n)
    Overall              : O(log(m*n))
    
    Space Complexity:
    -----------------
    O(1), since only constant extra space is used.
    
    Did this code successfully run on Leetcode:
    ------------------------------------------
    Yes
    
    Any problem you faced while coding this:
    ---------------------------------------
    Handling the case where the target does not fall within the range of
    any row, which requires an early exit to avoid invalid row access.

"""

class Solution:
    def searchMatrix(self, matrix, target):
        low = 0
        high = len(matrix) - 1

        while (low <= high):
            mid = (low + high)//2
            if target >= matrix[mid][0] and target <= matrix[mid][-1]:
                break
            elif target > matrix[mid][0]:
                low = mid + 1
            else:
                high = mid - 1
        midrow = mid

        low = 0
        high = len(matrix[0])-1

        while low <= high:
            mid = (low + high)//2
            if target == matrix[midrow][mid]:
                return True
            elif target > matrix[midrow][mid]:
                low = mid + 1
            else:
                high = mid - 1

        return False
        