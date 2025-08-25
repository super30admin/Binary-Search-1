# Time Complexity : O(log m + log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Remembering to search rows first, then columns


# Your code here along with comments explaining your approach in three sentences only
# First, use binary search on the last column of each row to find the candidate row where the target could be.
# Then, perform a normal binary search inside that row to check for the target.
# This ensures efficient search in a matrix that is sorted row-wise and column-wise.


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        l, r = 0, m - 1  # binary search boundaries for rows

        # Step 1: binary search over rows (check last element of each row)
        while l <= r:
            mid = (l + r) // 2

            if matrix[mid][n - 1] == target:  # if target matches last element of mid row
                return True

            elif matrix[mid][n - 1] < target: # target is larger, so search lower rows
                l = mid + 1
            else:   # target is smaller, search upper rows
                r = mid - 1

        if l >= m: # If target is greater than all last elements, it's not in matrix
            return False
        # Step 2: perform binary search inside the candidate row
        return self.binarySearch(matrix[l], target)

    def binarySearch(self, row, target):

        l, r = 0, len(row) - 1  # binary search boundaries for the row

        while l <= r:
            mid = (l + r) // 2

            if row[mid] == target:  # found the target
                return True

            if row[mid] > target:   # target lies on the left side
                r = mid - 1
            else:   # target lies on the right side
                l = mid + 1
        return False    # target not found in the row
