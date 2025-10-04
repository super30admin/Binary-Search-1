# SEARCH 2D MATRIX
# https://leetcode.com/problems/search-a-2d-matrix/description/

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        Goal is consider the 2d matrix as a 1d array and then do binary search
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m, n = len(matrix), len(matrix[0])
        low, high = 0, (m * n - 1)

        while(low <= high):
            mid = (low + high)//2
            row = mid//n
            col = mid % n
            if(matrix[row][col] == target):
                return True
            elif(matrix[row][col] < target):
                low = mid+1
            else:
                high = mid-1
        return False


