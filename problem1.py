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
            pivot_position = (left + right) // 2 
            pivot = matrix[pivot_position//columns][pivot_position%columns]
            if pivot == target:
             return True
            elif target < pivot:
                right = pivot_position-1
            elif target > pivot:
                left = pivot_position + 1
        
        return False