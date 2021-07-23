"""
Time Complexity:    O(log(mxn))
Space Complexity:   O(1)
YES, The code successfully ran on Leetcode

Approach - My approach is pretty straight forward, I am using binary search to search the target,
thinking the array is 1d rather than 2d. the catch here is how to know if mid is in what array so we use
mathematical expression like division and modulas to get the accurate reading.
"""


class Solution:
    """
    This function applies linear search
    TC - O(mxn)
    """
    def bruteForce(self, matrix: List[List[int]], target: int) -> bool:
        for row in matrix:
            if target in row:
                return True
        return False

    """
    This function applies linear search + binary search
    TC - O(n+m)
    """
    def efficient_1(self, matrix: List[List[int]], target: int) -> bool:
        for row in matrix:
            if row[len(row) - 1] < target:
                continue
            else:
                return target in row

    """
    This function applies linear search + binary search
    TC - O(log(mxn))
    """
    def efficient_2(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        left = 0
        right = m * n - 1
        while left <= right:
            mid = (left + right) // 2
            mid_value = matrix[mid // n][mid % n]
            if target == mid_value:
                return True
            else:
                if mid_value > target:
                    right = mid - 1
                elif mid_value < target:
                    left = mid + 1
        return False

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix is None or len(matrix) == 0:
            return False
        brute_Force = self.bruteForce(matrix, target)
        efficient_1 = self.efficient_1(matrix, target)
        efficient_2 = self.efficient_2(matrix, target)
        return efficient_2