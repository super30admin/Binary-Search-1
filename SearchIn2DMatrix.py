"""
    Problem Statement: Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.

    Approach: Since there is a n * m matrix and first element of the row is greater than the previous rows last element,
              the values are in the sorted order hence we'd use Binary Search.
              To get the index of the row we'd divide the number of items with the no of cols.
              No of cols would give use the exact index. Similarly get the index of col using
              mod operator.

    Time complexity: log(n)
    
    Space complexity: O(1).

    Accepted on LeetCode? Yes!
    LeetCode Link: https://leetcode.com/problems/search-a-2d-matrix/ 
"""

from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m_rows = len(matrix)
        n_cols = len(matrix[0])

        low = 0
        high = m_rows * n_cols - 1
        
        while (low <= high):
            mid = (low + high) // 2
            row = mid // n_cols
            col = mid % n_cols

            if target == matrix[row][col]:
                return True
            elif target < matrix[row][col]:
                high = mid - 1
            else:
                low = mid + 1
        return False

if __name__ == "__main__":
    s = Solution()
    matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
    target = 22
    ret = s.searchMatrix(matrix, target)
    print(f'Found {target} in the matrix') if ret else print('Target not found')