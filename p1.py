#TIme Complexityy :O(logn)
# Space COmplexity : O(1)
# Able to run on leetcode :Yes

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return False
        m,n= len(matrix),len(matrix[0])
        left,right = 0,m*n-1
        while left<=right:
            mid =  (left+right)//2        
            row = mid //n
            col = mid%n
            mid_val = matrix[row][col]
            print(mid_val)
            if mid_val == target:
                return True
            elif mid_val<target:
                left = mid+1
            else:
                right = mid-1
        return False