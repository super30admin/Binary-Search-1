# Time Complexity : O(log N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution(object):
    def searchMatrix(self, matrix, target):
        if len(matrix) == 0:
            return False
        
        rows = len(matrix)
        columns = len(matrix[0])
        
        left = 0
        right = (rows*columns)-1
        
        
        while (left <= right):
            midpoint = (left + right) // 2 
            mid_elem = matrix[midpoint//columns][midpoint%columns]
            if mid_elem == target:
                return True
            
            elif target < mid_elem:
                right = midpoint-1
            elif target > mid_elem:
                left = midpoint + 1
        
        return False