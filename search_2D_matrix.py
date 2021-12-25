"""
    Time Complexity : O(logN)
    Space Complexity : O(1)
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
"""
def searchMatrix(matrix, target):
    m = len(matrix)  # row
    n = len(matrix[0])  # col
    if m == 0:
        return False
    left = 0
    right = m * n - 1

    while left <= right:

        mid = (left+right) // 2
        # row, column, middle element
        mid_num = matrix[mid // n][mid % n]

        if mid_num == target:
            return True

        elif mid_num > target:
            right = mid-1

        else:
            left = mid + 1

    return False


# Driver code
matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
print("Search 1:", searchMatrix(matrix, 1))
print("Search 70:", searchMatrix(matrix, 70))
