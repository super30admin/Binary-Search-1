def searchMatrix(matrix, target: int) -> bool:
    if len(matrix) == 0:
        return False
    m = len(matrix)  # number of Rows in the matrix
    n = len(matrix[0])  # number of Cols in the matrix
    low = 0
    high = m * n - 1
    while low <= high:
        mid = low + (high - low) // 2
        r, c = divmod(mid, n)
        if matrix[r][c] == target:
            return True
        elif matrix[r][c] < target:
            low = mid + 1
        else:
            high = mid - 1
    return False


matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
target = 3
print(searchMatrix(matrix, target))
