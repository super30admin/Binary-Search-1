'''
We do a binary search along two dimensions in the matrix. 
One is along the rows of the matrix and the other across the cols of the matrix

Time complexity - O(mn) - 
Space complexity - O(1) - No extra space
'''

class SearchMatrix:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row, cols = len(matrix), len(matrix[0])

        top, bot = 0, row - 1

        while top <= bot:
            row = (top + bot) // 2
            if target > matrix[row][-1]:
                top = row + 1
            elif target < matrix[row][0]:
                bot = row - 1
            else:
                break

        if not (top <=  bot):
            return False

        row = (top + bot) // 2
        l, r = 0 , cols - 1

        while l <= r:
            m = (l + r) // 2
            if target > matrix[row][m]:
                l = m + 1
            elif target < matrix[row][m]:
                r = m - 1
            else:
                return True
            
        return False