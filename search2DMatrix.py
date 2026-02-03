''' 
Time Complexity : O(log n)
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
'''
class Solution:
    def searchMatrix(self, matrix, target):
        n = len(matrix)
        m = len(matrix[0])
        low = 0
        high = (n * m) - 1

        while low <= high:
            mid = (high + low) // 2
            i = mid // m
            j = mid % m
            if matrix[i][j] == target:
                return True
            
            if matrix[i][j] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return False