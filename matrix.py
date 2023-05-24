# // Time Complexity : O(n*m)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :YES
# // Any problem you faced while coding this :NO


# // Your code here along with comments explaining your approach

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
      for row in matrix:
        if target in row:
          return True
      return False