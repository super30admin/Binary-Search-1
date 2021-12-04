# Time Complexity : O(Log(n))
# Space Complexity:o(1)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix == None or len(matrix) is 0:
            return False

        height = len(matrix)
        length = len(matrix[0])

        print(length, height)
        low = 0
        high = length * height - 1
        print(low, high)

        while low <= high:
            mid = low + (high - low) // 2
            row = int(mid // length)
            column = int(mid % length)
            if matrix[row][column] == target:
                return True
            elif target < matrix[row][column]:
                high = mid - 1
            else:
                low = mid + 1
        return False
