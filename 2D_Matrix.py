#Time complexity: O(logn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: yes
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        row = len(matrix)
        col = len(matrix[0])
        start = 0
        end = (row*col)-1
        while start <= end:
            midIdx = (start+end)//2
            mid = matrix[midIdx//col][midIdx%col]
            if target == mid:
                return True
            else:
                if target > mid:
                    start = midIdx + 1
                else:
                    end = midIdx - 1
        return False
        
        