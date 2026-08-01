#  Time Complexity : O(log(m * n))
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : yes
#  Any problem you faced while coding this : No

# Approach: Assumping the matrix as a flat array and calculating right index using mathematical division and modulo help to reduce the space and time complexity,
# once we know what row the target exist we perform binary search and if the target is not present we exist out as false


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix[0])
        n = len(matrix)

        low = 0
        high = (m * n) - 1

        while low <= high:
            mid = (low + high) // 2
            r = mid // m
            c = mid % m
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] < target:
                low = mid + 1
            else:
                high = mid - 1
        return False
