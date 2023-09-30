# time complexity: O(log(m)+log(n)) or O(log(m*n)) where m = # of rows and n = # of columns in a row
# space complexity: O(1) as no additional space used
# # Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : confused on the formula we have used to find the vector for mid element
# i.e. mid_row = mid//n and mid_column = mid%n

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """

        # number of rows
        m = len(matrix)

        # number of columns
        n = len(matrix[0])

        # consider the 2D matrix as 1D list of list of int with total length m*n
        lo = 0
        hi = (m*n)-1

        while lo <= hi:
            mid = (lo + hi) // 2

            # find vector of mid idx
            mid_row = mid//n
            mid_col = mid % n

            # normal BS
            if (matrix[mid_row][mid_col] == target):
                return True
            elif (matrix[mid_row][mid_col] > target):
                hi = mid - 1
            else:
                lo = mid + 1

        return False    # return false if element not found
