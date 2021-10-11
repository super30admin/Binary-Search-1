# Time Complexity: O(log(n) + log(m))     where m & n represents rows & columns respectively.
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Logic: apply binary search on finding row index first & then apply binary search in finding the column index. If both
# found return True else False.

class Solution:

    def _get_index(self, matrix, target, start, end, row_index):
        while start <= end:
            mid = start + (end-start)//2
            if row_index == -1:     # for row index
                if matrix[mid][0] <= target <= matrix[mid][-1]:
                    return mid
                if target < matrix[mid][0]:
                    end = mid - 1
                else:
                    start = mid + 1
            else:                   # for column index
                if matrix[row_index][mid] == target:
                    return mid
                if matrix[row_index][mid] < target:
                    start = mid + 1
                else:
                    end = mid - 1

    def searchMatrix(self, matrix, target):
        rows = len(matrix)
        col = len(matrix[0])
        r_index = self._get_index(matrix, target, 0, rows-1, -1)
        if r_index is None:
            return False
        c_index = self._get_index(matrix, target, 0, col-1, r_index)
        if c_index is None:
            return False
        return True


matrix1 = [[1]]
target1 = 2
sol1 = Solution()
print(sol1.searchMatrix(matrix1, target1))
