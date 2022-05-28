"""
Status - also try direction approach start with arr[m][0] or arr[0,n] and run in a direction based on if the target is
smaller or greater.
This approach will work even if previous row last element is not lesser than current rows first element.

Leetcode - https://leetcode.com/problems/search-a-2d-matrix/submissions/ (submitted)
TC - O(log(m*n))
Challenge - finding formula for mapping 1D array matrix to 2D array matrix for element lookup

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
10^4 <= matrix[i][j], target <= 10^4
"""


class Solution:
    """
    Idea - Since all the elements of one row are smaller than next, it can be looked as one sorted 1-D array.
    It will be like performing binary search on a 1-D array
    Now the challenge would be to find a formula for mapping 1D array matrix to 2D array matrix for element lookup.

    Transformation-
    [[1,     2,    3],     [4,   5,    6]] -> [1,2,3,4,5,6]
      0,1    0,2   0,3     1,0   1,1   1,2     0 1 2 3 4 5   <- index

      eg. mapping for index 5 of 1-D in the 2-D array- [5 // 3, 5 % 3] = [1, 2]
      ie. our mapping formula for index 'x' would be - [x // n, x % n]
    """
    # TC- O(log(m*n)), SC - O(1)
    def searchMatrix(self, matrix, target):
        m, n = len(matrix), len(matrix[0])
        low, high = 0, m * n - 1
        while low <= high:
            mid = low + (high - low) // 2
            x, y = mid // n, mid % n
            if matrix[x][y] == target:
                return True
            elif target < matrix[x][y]:
                high = mid - 1
            else:
                low = mid + 1

        return False

    ''' 
    Idea - search each row with its first and last element to find which row the value may belong to,
    and run binary on that row
    '''

    # TC- O(m + lognN), SC- O(1)
    def searchMatrix1(self, matrix, target):
        targetFound = False
        targetRow = None
        rowLen, colLen = len(matrix), len(matrix[0])
        for row in matrix:
            if target >= row[0] and target <= row[colLen - 1]:
                targetRow = row
                break

        if targetRow is None:
            return False
        else:
            # bst on the row
            l, r = 0, colLen - 1
            while l <= r:
                mid = (l + r) // 2
                if row[mid] == target:
                    targetFound = True
                    break
                elif target <= row[mid]:
                    r = mid - 1
                else:
                    l = mid + 1

            return targetFound


# print(Solution().searchMatrix([[1, 2, 3], [4, 5, 6]], 5))
