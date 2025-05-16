#t.c. => O(log(m*n))
#s.c. => O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : No
#approach => treat the matrix as a flat array and convert mid to row and column idx
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        l, r = 0, ((m * n) - 1)

        while l <= r:
            mid = l + (r - l)//2
            row = mid // n
            col = mid % n
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                l = mid + 1
            else:
                r = mid - 1
        return False