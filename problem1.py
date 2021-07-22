## Problem1 
#Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
#time complexity: O(logn)
#Leet code solution accepted in python 1 and rejected in python 3 due to midpoint_element.
#solution explained in the java part of this question.
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if (len(matrix))==0:
            return False
        rows = len(matrix)
        columns = len(matrix[0])
        left = 0
        right = (rows*columns)-1
        while(left<=right):
            midpoint = left+(right-left)/2
            midpoint_element = matrix[midpoint/columns][midpoint%columns]
            if(midpoint_element==target):
                return True
            elif target>midpoint_element:
                left = midpoint+1
            elif target<midpoint_element:
                right = midpoint-1
        return False