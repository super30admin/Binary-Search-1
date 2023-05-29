# Time Complexity : O(log(mn)) where m and n are number of rows and columns resp.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We define the search space to be 0 to m*n, and then shrink the search space towards our target using binary search.
# We divide the index by rowSize to get row number and take modulus with rowSize to get column number.

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        l, h = 0, (len(matrix)*len(matrix[0]))-1
        rowsize = len(matrix[0])

        while l <= h:
            m = l + (h-l)//2
            posNum = matrix[m//rowsize][m%rowsize]
            if posNum == target:
                return True
            elif posNum < target:
                l = m + 1
            else:
                h = m - 1
        return False