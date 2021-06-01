# // Time Complexity : O(log n + log m) Where m and n are rows and columns respectively
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low = 0
        m = len(matrix)  # rows
        n = len(matrix[0])  # Cols
        high = m * n - 1

        while (high >= low):
            mid = low + (high - low) // 2  # Avoiding Integer Overflow

            i = mid // n    # To get the index of row  divide mid index with number of Columns
            j = mid % n    # To get the index of col, do the mod operation on mid index  and number  of Columns

            mid_element = matrix[i][j]

            if target == mid_element:
                return True
            elif target > mid_element:
                low = mid + 1
            else:
                high = mid - 1

        return False

