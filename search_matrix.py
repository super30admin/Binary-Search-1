"""
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Time Complexity: O(log(m*n))
Space Complexity: O(1)
"""


def search_matrix(matrix, target):
    if not matrix or len(matrix) == 0:
        return False

    m, n = len(matrix), len(matrix[0])
    low, high = 0, m*n-1

    while low <= high:
        mid = (low+high)//2
        mid_row, mid_col = mid//n, mid % n
        if matrix[mid_row][mid_col] == target:
            return True
        elif matrix[mid_row][mid_col] < target:
            low = mid+1
        else:
            high = mid-1

    return False


matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
target = 3
print(search_matrix(matrix, target))

matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
target = 13
print(search_matrix(matrix, target))
