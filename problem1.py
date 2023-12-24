""" The problem is solved using binary search. The low pointer is at the first element of the first
    array, and the high pointer is at the last element of the last array. This way, I am converting
    the 2D matrix into a one dimensional array and then applying binary search, since the internal
    array is also sorted. In order to execute the binary search, the rows and columns of the matrix
    are calculated using '%' and / operations.
    Time Complexcity: O(log m*n), where m is the size of the internal array, and n is the size of the outer array
    Space Complexcity: O(1)
"""

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        n, m = len(matrix), len(matrix[0])
        low = 0
        high = (n*m) - 1

        while (low <= high):
            mid = low + (high - low)//2
            row = mid // m
            col = mid % m
            if (matrix[row][col] == target):
                return True
            elif (matrix[row][col] < target):
                low = mid + 1
            else:
                high = mid - 1
        return False

        