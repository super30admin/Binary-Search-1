# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes

class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        if not matrix or len(matrix) == 0:
            return False
        m = len(matrix)
        n = len(matrix[0])
        
        low = 0
        high = (m*n)-1
        
        while(low<=high):
            mid = low+(high-low)//2
            r = mid//n
            c = mid%n
            if(matrix[r][c] == target):
                return True
            elif(target>matrix[r][c]):
                low = mid+1
            else:
                high = mid-1
        return False
                