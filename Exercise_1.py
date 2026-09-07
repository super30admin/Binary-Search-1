'''
https://leetcode.com/problems/search-a-2d-matrix/description/

Time Complexity :

O(log(n))

Space Complexity :

O(1)

Did this code successfully run on Leetcode :

Yes

Conceptual Approach:

This matrix, if flattened, is just a sorted array. Of course we do not want to utilize additional space, so we should navigate this matrix as if
it were a 1D array instead. We can achieve this by double hashing the element number into the column and row indices.

Using n I will calculate the row and column index by:

- Row index = (element number) / n
- Column index = (element number - 1) % n

Edge Cases:

- 1 x 1 matrix

Constraints:
Always break down the constraints and understand if we are being given hints or if this will materially alter our design

- Each row is sorted in non-decreasing order
- The first integer of each row is greater than the last integer of the previous row
This is just the same constraint as above but for the columns

- Must be in O(log(m * n)) complexity

Therefore we must conduct a binary search

- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 100
We know that there isn't a empty matrix case, but we should handle the case where the matrix is just 1 x 1
- -10^4 <= matrix[i][j], target <= 10^4
We know that the target value and the matrix values are in the same input space 

Any problem you faced while coding this:
- I had an off by one error when setting high that would result in certain boundary cases failing (a 1x1 matrix, a 1x2 matrix)
'''
from typing import List

class Solution:
    def search_matrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = (m * n) - 1

        while low <= high:
            # We calculate the mid this way to avoid integer overflow even though we could say mid = (high + low) // 2
            mid = low + (high - low) // 2
            row_index = mid // n
            column_index = (mid) % n

            print(low, high)

            if matrix[row_index][column_index] == target:
                return True
            elif matrix[row_index][column_index] < target:
                low = mid + 1
            else:
                high = mid - 1

        return False
        