'''
## Problem 74: Search a 2D Matrix

## Author: Neha Doiphode
## Date:   06-25-2022

## Description:
    Write an efficient algorithm that searches for a value target in an m x n integer matrix called matrix.
    This matrix has the following properties:
        * Integers in each row are sorted from left to right.
        * The first integer of each row is greater than the last integer of the previous row.

## Examples:

    Example 1:

        Input: matrix = [[ 1, 3, 5, 7],
                         [10,11,16,20],
                         [23,30,34,60]], target = 3
        Output: true


    Example 2:

        Input: matrix = [[ 1, 3, 5, 7],
                         [10,11,16,20],
                         [23,30,34,60]], target = 13
        Output: false

    Example 3:

        Input: matrix = [[ 1]], target = 2

        Output: false

    Example 4:

        Input: matrix = [[ 1]], target = 1

        Output: true


## Constraints:
    m == matrix.length(rows)
    n == matrix[i].length(columns)
    1 <= m, n <= 100
    -104 <= matrix[i][j], target <= 104

## Time complexity:
    * If simple search is performed, O(m * n), where m = number of rows, n = number of columns
    * If binary search is performed on all rows, O(m * log n), where m = number of rows, n = number of columns
    * Out of approaches implemented below "searchMatrix_1" uses, binary search ONLY on the "potential row" where it "thinks" target might be part of.
        Hence, O(n), to loop thru rows of matrix to find the right row.
               O(log n), to perform the binary search.
               Total = O(n) + O(log n) ~= O(n) asymptotic.

    * If we want to optimize it further, according to "searchMatrix_2" approach below, we can make use of binary search on first column to find out the "potential row".
      So, instead of performing binary search on all rows, we can only perform binary search on the row on which we think the target might be present.
      This should reduce the time complexity even further.
      Hence, O(log n), to find out the potential row using binary search on first column.
             O(log n), to perform binary search on the potential row to find the actual element.
             Total = O(log n) asymptotic.

## Space complexity: O(1), No auxiliary space is used.
'''
from typing import List

class Solution:
    def binary_search(self, matrix, row, target) -> int:
        low = 0
        high = len(matrix[row]) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if target == matrix[row][mid]:
                return True

            elif target < matrix[row][mid]:
                high = mid - 1

            else:
                low = mid + 1

        return False

    def searchMatrix_1(self, matrix: List[List[int]], target: int) -> bool:
        answer = -1
        for row in range(len(matrix)):
            if matrix[row][0] <= target <= matrix[row][len(matrix[row]) - 1] and self.binary_search(matrix, row, target):
                return True
        return False

    def searchMatrix_2(self, matrix: List[List[int]], target: int) -> bool:
        """
        * Flatten the 2D array.
        """

        # Total number of rows
        m = len(matrix)

        # Total number of columns
        n = len(matrix[0])

        # low
        low = 0

        # high
        high = m * n - 1

        while low <= high:
            mid = low + (high - low) // 2
            row = mid % n
            column = mid // n
            print(f"Element = {matrix[row][column]}, low = {low}, high = {high}, mid = {mid}, row = {row}, column = {column}")

            if target == matrix[row][column]:
                return True

            elif target < matrix[row][column]:
                high = mid - 1
            else:
                low = mid + 1

        return False


# Driver code
solution = Solution()
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 1
answer = solution.searchMatrix_2(matrix, target)
print()
print(f'Matrix: {matrix}')
print(f'Target: {target}')
print(f'Answer: {answer}')
