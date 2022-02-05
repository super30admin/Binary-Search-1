# Time Complexity : O(logmn); where m and n are rows and coloums in matrix
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Binary Search

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        s, e = 0, (m*n)-1
        
        while s<=e:
            mid = (s+e)//2
            i, j = mid // n, mid % n
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] < target:
                s = mid+1
            else:
                e = mid-1
        return False   
