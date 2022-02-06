# -*- coding: utf-8 -*-
"""
Created on Sat Feb  5 17:28:02 2022

@author: BJay
"""

#Time Complexity : O(log(mn))
#Space Complexity : O(1)
#Runs fine on leetcode
#It was a tricky hack to solve this proble, could do it with brutforce nd then runing it on binarysearch
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        left, right = 0, m * n - 1
        while left < right:
            mid = (left + right) >> 1
            x, y = divmod(mid, n)
            if matrix[x][y] >= target:
                right = mid
            else:
                left = mid + 1
        return matrix[left // n][left % n] == target
    
    
    
    
    
    
    
#     def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
#         m = len(matrix)
#         n = len(matrix[0])
#         start = 0
#         end = (m*n) - 1
        
#         while start<end:
#             mid = start + (end-start)//2
#             i = mid//m
#             j = mid % n
            
#             if matrix[i][j] == target:
#                 return True
#             elif target < matrix[i][j]:
#                 end = mid-1
#             else:
#                 start = mid+1
                
                
    
        # for i in range(len(matrix)):
        #     if target>matrix[i][-1]:
        #         continue
        #     l = 0
        #     h = len(matrix[i])
        #     while l<=h:
        #         mid = int((h + l)/2)
        #         if target == matrix[i][mid]:
        #             return 1
        #         elif target > matrix[i][mid]:
        #             l = mid+1
        #         else:
        #             h = h-1
                
        