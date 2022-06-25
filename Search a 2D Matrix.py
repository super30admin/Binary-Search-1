# Time Complexity : O(log(m*n))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        l=0
        r= (m*n) - 1


        while ( l<=r):
            # To avoid integer overflow

            mid = l+(r-l)//2
            print(mid)
            
            if matrix[mid//n][mid%n]== target:
                return True
            elif matrix[mid//n][mid%n]>target:
                r= mid-1
            else:
                l= mid+1
                
        return False        