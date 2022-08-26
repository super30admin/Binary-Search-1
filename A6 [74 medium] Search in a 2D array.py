# Time Complexity : O(log mxn)
# Space complexity: O(1)  //as we are not using any additional auxillary data structure

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        n = len(matrix)
        m = len(matrix[0])
        low = 0
        high = m * n - 1

        #       null condition
        if (n == 0 or matrix is None):
            return False

        #       Apply binary search
        while low <= high:
            mid = low + (high - low) // 2
            r = mid // m
            c = mid % m
            print(r)
            print(c)

            if matrix[r][c] == target:
                return True

            elif matrix[r][c] < target:
                low = mid + 1

            else:
                high = mid - 1

        return False