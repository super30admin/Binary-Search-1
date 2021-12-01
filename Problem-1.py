# Time Complexity : O(m+n) where m is the no of rows and n is the no of columns
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

#Your code here along with comments explaining your approach
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n=len(matrix)
        if not matrix or len(matrix)==0:
            return False
        
        r=0
        c=len(matrix[0])-1
        
        while r<len(matrix) and c>=0:
            if matrix[r][c]==target:
                return True
            
            if target<matrix[r][c]:
                c-=1
            else:
                r+=1
        
        return False
        