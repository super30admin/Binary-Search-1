'''
First we search the first column to find appropriate row.
If the mid row has numbers that can contain the target then we return the mid to do a second searh 
to find the target in the row.

Then we perform the binary search on the row to find the target and return True if present or False if absent.
'''

class Solution:

    def searchRow(self, matrix, target):
        l = 0
        r = len(matrix)-1

        while l <= r:
            m = l + (r-l)//2

            if matrix[m][0] <= target <= matrix[m][-1]:
                return m

            if matrix[m][0] > target:
                r = m-1
            else:
                l = m+1

        return -1

    def searchCol(self, matrix, row, target):
        l = 0
        r = len(matrix[row]) - 1

        while l <= r:
            m = l + (r-l)//2

            if matrix[row][m] == target:
                return True

            if matrix[row][m] > target:
                r = m-1
            else:
                l = m+1

        return False

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row = self.searchRow(matrix, target)
        print(row)
        if row == -1:
            return False

        return self.searchCol(matrix, row, target)

