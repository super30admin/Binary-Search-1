class Solution:
    '''
    Time Complexity: O(log n)
    Space Complexity: O(1)
    '''
    def searchMatrix(self, matrix, target: int) -> bool:

        row = len(matrix)-1
        col = 0

        while row >= 0 and col < len(matrix[0]):
            if target == matrix[row][col]: return True

            if target < matrix[row][col]:
                row -= 1
            else:
                col += 1

        return False