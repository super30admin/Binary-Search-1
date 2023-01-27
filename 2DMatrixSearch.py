"""
Rasika Sasturkar
Time Complexity: O(logm + logn)
Space Complexity: O(1)
"""


def searchMatrix(matrix, target) -> bool:
    """
    We treated the 2D matrix as 1D-array and implemented binary search
    on the entire array. We found the mid of 1-D array but to find the
    corresponding mid in 2-D matrix, we divided mid by no. of columns to
    get the row, and mid modulo no. of columns to get the column index.
    Then, again perform binary search until we find the target in 2-D matrix.
    It will return False, if matrix is empty or target is not present in matrix.
    """
    if matrix is None or len(matrix) == 0:
        return False
    n = len(matrix)  # rows
    m = len(matrix[0])  # cols
    low = 0
    high = m * n - 1
    while low <= high:
        mid = low + (high - low) // 2
        r = mid // m
        c = mid % m
        if matrix[r][c] == target:
            return True
        elif matrix[r][c] > target:
            high = mid - 1
        else:
            low = mid + 1
    return False


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    matrix1 = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
    target1 = 3
    print(searchMatrix(matrix1, target1))  # returns true
    matrix2 = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
    target2 = 13
    print(searchMatrix(matrix2, target2))  # returns false


if __name__ == "__main__":
    main()
