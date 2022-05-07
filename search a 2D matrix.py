# Time Complexity : O(log mn), where m and n represents number of rows and columns
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        
        l, r = 0, m*n-1
        while l <= r:
            p_ind = (l+r)//2
            p = matrix[p_ind//n][p_ind%n]
            if target == p:
                return True
            else:
                if target < p:
                    r = m - 1
                else:
                    l = m + 1
        return False