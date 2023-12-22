#Time Complexity: O(log m * n)
#Space Complexity: O(1)

class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        if not matrix or len(matrix) == 0:
            return False
        
        
        m = len(matrix)#r
        n = len(matrix[0])#c
        low = 0
        high = m * n - 1

        while low <= high:
            mid = low + (high - low) // 2 #to avoid integer overflow issue
            row = mid // n
            column = mid % n
            if matrix [row][column] == target:
                return True

            elif target < matrix[row][column]:

                high = mid - 1

            else:
                low = mid + 1

        return False
             