'''
Time Complexity : O(n+m), where n is rows and m is cols
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach:
        start searching from matrix[rows-1][0]
        if target is smaller shift up(check upper row)
        if target is bigger shift right(check next col)
'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])

        i = rows-1
        j = 0

        while i>=0 and i<rows and j>=0 and j<cols:
            if matrix[i][j] == target:
                return True
            elif target < matrix[i][j]:
                i-=1
            else:
                j+=1
        
        return False

        #complexity O(m+n)