# Time Complexity : O(Log(mn))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


def search_matrix(matrix: List[List[int]], target: int) -> bool:
    m = len(matrix)
    n = len(matrix[0])
    left = 0
    right = m * n - 1
    while left <= right:
        index = (left + right) // 2
        row = index // n
        col = index % n
        if matrix[row][col] == target:
            return True
        elif matrix[row][col] > target:
            right = index - 1
        else:
            left = index + 1
    return False


matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
target = 3

print(search_matrix(matrix, target))
