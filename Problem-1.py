"""
Approach #1: LINEAR ARRAY SEARCH
1) the goal is to construct an imaginary 1d-array by mapping the elements of the given 2-d array such that you append
each row from top to bottom. This would be a sorted array and we could use binary search to check if our target is present

m * n -> len_rows * len_columns

2) you can divide the imaginary array into m parts with n elements each.
    a) So your matrix row index can be mapped as
        matrix_row = array_index // len_columns
    b) matrix column index can be mapped as
        matrix_col = array_index % len_columns

#Approach # 2 LOWEST NEAREST NEIGHBOR
The idea is to affix to the row which is highly likely to have the target values and ditch all remaining rows
(this can be achieved by implementing lowest nearest neighbor binary search), then we can conduct a binary search at
that row alone.
 1) Since the arrangement is such that the first col or any row would be always the lowest element of that row,
 we can do a vertical binary search on col 1. The search would return the row index of the element that is
 equal to target or the closest value less than the target
 2)  Search the row for the target, if not found return False

 Implementation of lowest nearest neighbor binary:
 1) Since we need to search the first vol only, we fix the col index to 0 and assign low and high pointers with row
 indices
 2) we could either find the target itself or a value that is closest to and less than the target
 3) return -1 if such a value is not found

 Edge cases:
 1) if we find that there is no lowest nearest neighbor we return -1
    a) The first element in the col could be greater than target
2) we have reached the last element of the col and it is less than target, this would be the lowest nearest neighbor
"""


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        """ # Approach 1: Linary Array
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = ( m * n ) - 1

        while low <= high:

            mid = low + (high - low)//2

            r = mid // n
            c = mid % n

            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                high = mid -1
            else:
                low = mid + 1

        return False
        """
        # Approach 2: traversal using nearest neighbor
        last_row = len(matrix) - 1
        last_col = len(matrix[0]) - 1

        # row indices of first col
        lo = 0
        hi = last_row

        # would always be the first col, use row indices only
        row = self.lowest_nearest_neighbor(lo, hi, matrix, target, last_row)
        if row == -1:
            return False

        if matrix[row][0] == target: # if the nearest neighbor is target
            return True

        # Binary search in the potential row with target, use cols only as the row index is fixed
        lo = 0  # first index of row
        hi = last_col

        while lo <= hi:

            mid = lo + (hi - lo) // 2
            if matrix[row][mid] == target:
                return True

            elif matrix[row][mid] < target:
                lo = mid + 1

            else:
                hi = mid - 1
        return False

    # finds the nearest neighbor lower than the target, always operates on the first col
    def lowest_nearest_neighbor(self, lo, hi, matrix, target, last_row):
        if target < matrix[lo][0]:
            return -1

        while lo <= hi:

            mid = lo + (hi - lo) // 2

            if matrix[mid][0] == target \ # if found
                    or ((mid == 0 or matrix[mid - 1][0] < target) \ # compare with vertical neighbors with edge cases
                        and (mid == last_row or matrix[mid - 1][0] > target)):
                return mid

            elif matrix[mid][0] > target:
                hi = mid - 1

            else:
                if (mid == last_row or matrix[mid + 1][0] > target): # edge case if reached the last element of the col
                    return mid
                else:
                    lo = mid + 1
        return -1

"""
In both approaches:
Timex Complexity: O(log n)
space Complexity: O(1)
"""