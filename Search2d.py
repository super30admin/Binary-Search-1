#Time complexity for put and get: O(log mn)
#Space complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m = len(matrix)
        n = len(matrix[0])
        # consider matrix as 1d matrix and then find indices
        l = 0
        h = m*n-1
        
        if m == 0:
            return False
        while l<=h:
            mid = l + (h-l)//2
            # row is 1d index divided by number of columns and column is 1d index modulo number of columns
            r = mid // n
            c = mid % n
            if matrix[r][c] == target:
                return True
            elif target < matrix[r][c]:
                h = mid - 1
            else:
                l = mid + 1
        
        return False
        