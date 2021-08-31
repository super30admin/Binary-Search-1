#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Aug 27 16:20:48 2021

@author: ameeshas11
"""

#Time Complexity : O(log m + log n)
#Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : in finding row, binary search has to find the range in which 
#                                          the target lies not the exact value
    
class Solution:
    #find the row that would contain target value
    def binary_search_row(self, matrix, low, high, x):
        if high >= low: 
            mid = (high + low) // 2
            if matrix[mid][0] == x:
                return mid
            elif high - mid == 1 and matrix[mid][0] < x and matrix[high][0] > x:
                return mid
            elif x >= matrix[high][0]:
                return high 
            elif matrix[mid][0] > x:
                return self.binary_search_row(matrix, low, mid-1, x)
            else:
                return self.binary_search_row(matrix, mid, high, x)
        else: 
            return -1
        
    #find the target value in that row   
    def binary_search_col(self, matrix, low, high, row, x):
        if high >= low:
            mid = (high + low) // 2
            if matrix[row][mid] == x:
                return True
            elif matrix[row][mid] > x:
                return self.binary_search_col(matrix, low, mid - 1, row, x)
            else:
                return self.binary_search_col(matrix, mid + 1, high, row, x)
        else:
            return False
        
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        self.row = len(matrix)
        self.col = len(matrix[0])
        find_row = self.binary_search_row(matrix, 0, self.row-1, target)
        if find_row == -1:
            return False
        else:
            find_col = self.binary_search_col(matrix, 0, self.col-1, find_row, target)
            if find_col == True:
                return True
            else:
                return False
            
            