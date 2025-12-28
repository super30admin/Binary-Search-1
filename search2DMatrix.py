''' Time Complexity : O(log(m * n))
    Space Complexity : O(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Your code here along with comments explaining your approach

   Approach :Converting the  2D array into 1D array and perforning simple binary search
'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        l, h = 0, (m * n)-1
        while l <= h:
            mid = (l+h) // 2
            r = mid // n
            c = mid % n
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] < target:
                l = mid + 1
            else:
                h = mid - 1
        return False

         