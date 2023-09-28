// Time Complexity :O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A


// Your code here along with comments explaining your approach in three sentences only
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        reqRow = -1
        rows = len(matrix)
        cols = len(matrix[0])
      
        for i in range(rows):
            if matrix[i][cols-1] > target:
                reqRow = i
                break
            elif matrix[i][cols-1] == target:
                return True 
        while(reqRow < 0):
            return False 
          
        for j in range(len(matrix[0]))[::-1]:
            if matrix[reqRow][j] == target:
                return True
        return False
