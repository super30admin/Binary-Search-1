# Note: To run on Leetcode, replace the class name with "Solution" and remove the test cases at the bottom of the file.
"""
Time Complexity : O(m * n) where m is number of rows and n is number of columns
Space Complexity : O(1)
Did this code successfully run on Leetcode (Problem 74. Search a 2D Matrix): Yes but Time Limit Exceeded / Restrictions Failed
Any problem you faced while coding this : None

Approach: 
Scan every single cell of the matrix one by one from top-left to
bottom-right, comparing it against the target. If any cell matches the
target, return True immediately; otherwise return False once every cell has
been checked. This ignores the row-sorted and column-sorted structure of
the matrix entirely, so it is the simplest but slowest approach.
"""
from typing import List
class SolutionBruteForce:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix is None or len(matrix) == 0 or target is None:
            return False
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == target:
                    return True
        return False


"""
Time Complexity : O(m log n) where m is number of rows and n is number of columns
Space Complexity : O(1)
Did this code successfully run on Leetcode (Problem 74. Search a 2D Matrix): Yes but Time Limit Exceeded / Restrictions Failed
Any problem you faced while coding this : None

Approach: Treat each row as its own sorted array and run a standard binary
search on that row to look for the target. Repeat this row-by-row binary
search for every row in the matrix until the target is found. This is
faster than brute force because it exploits the fact that each row is
individually sorted, but it still does not use the sorted relationship
between rows.
"""
class SolutionRowBinarySearch:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix is None or len(matrix) == 0 or target is None:
            return False
        rows = len(matrix)
        cols = len(matrix[0])

        for i in range(rows):
            left = 0
            right = cols - 1
            while left <= right:
                mid = left + (right - left) // 2
                if matrix[i][mid] == target:
                    return True
                elif matrix[i][mid] > target:
                    right = mid - 1
                else:
                    left = mid + 1
        return False


"""
Time Complexity : O(m + n) where m is number of rows and n is number of columns
Space Complexity : O(1)
Did this code successfully run on Leetcode (Problem 74. Search a 2D Matrix): Yes but Time Limit Exceeded / Restrictions Failed
Any problem you faced while coding this : None

Approach (Two Pointers): Start a pointer at the top-right corner of the matrix and use the
fact that values increase going down and decrease going left. If the
current value is smaller than the target move the row pointer down, and if
it is larger move the column pointer left, until the target is found or the
pointers walk off the matrix. This "staircase search" only ever moves
through at most one full row plus one full column, giving linear time.
"""
class SolutionStaircaseSearch:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix is None or len(matrix) == 0 or target is None:
            return False
        rows = len(matrix)
        cols = len(matrix[0])

        row_pointer = 0
        col_pointer = cols - 1

        while row_pointer < rows and col_pointer >= 0:
            if matrix[row_pointer][col_pointer] == target:
                return True
            elif matrix[row_pointer][col_pointer] < target:
                row_pointer += 1
            else:
                col_pointer -= 1
        return False


"""
Time Complexity : O(log(m * n)) where m is number of rows and n is number of columns
Space Complexity : O(1)
Did this code successfully run on Leetcode (Problem 74. Search a 2D Matrix): Yes Optimal Solution
Any problem you faced while coding this : How to identify midpoint element
especially when converting from 1D index to 2D coordinates.

Approach: Since every row's last element is smaller than the next row's
first element, the whole matrix behaves like one flattened sorted array of
size m*n, so a single binary search works over the range [0, m*n - 1].
Convert each midpoint index back into a (row, col) pair using integer
division and modulo by the column count to fetch the actual matrix value.
This gives the fastest approach of the four since it does one binary
search over the entire matrix instead of one per row.
"""
class SolutionFlattenedBinarySearch:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix is None or len(matrix) == 0:
            return False
        row = len(matrix)
        col = len(matrix[0])
        left = 0
        right = (row * col) - 1
        while left <= right:
            midpoint = left + (right - left) // 2
            midpoint_element = matrix[midpoint // col][midpoint % col]
            if midpoint_element == target:
                return True
            elif midpoint_element < target:
                left = midpoint + 1
            else:
                right = midpoint - 1
        return False


def run_tests():
    solutions = {
        "Brute Force": SolutionBruteForce(),
        "Row Binary Search": SolutionRowBinarySearch(),
        "Staircase Search": SolutionStaircaseSearch(),
        "Flattened Binary Search": SolutionFlattenedBinarySearch(),
    }

    test_cases = [
        # (matrix, target, expected)
        ([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 3, True),
        ([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 13, False),
        ([[1]], 1, True),
        ([[1]], 2, False),
        ([[]], 1, False),
        ([], 1, False),
        ([[1, 3]], 3, True),
        ([[-5, -3, 0, 4], [5, 8, 12, 19]], -3, True),
        ([[-5, -3, 0, 4], [5, 8, 12, 19]], 1, False),
    ]

    all_passed = True
    for name, solution in solutions.items():
        print(f"\n--- Testing {name} ---")
        for idx, (matrix, target, expected) in enumerate(test_cases, start=1):
            result = solution.searchMatrix(matrix, target)
            status = "PASS" if result == expected else "FAIL"
            if status == "FAIL":
                all_passed = False
            print(
                f"Test {idx}: matrix={matrix}, target={target} "
                f"-> got={result}, expected={expected} [{status}]"
            )

    print("\n=== Overall:", "ALL TESTS PASSED" if all_passed else "SOME TESTS FAILED", "===")


if __name__ == "__main__":
    run_tests()