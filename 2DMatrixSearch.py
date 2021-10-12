# Time Complexity : O(log(m*n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    
  def searchColumnsInRow(self, matrix, target, row):
    if not matrix[row]:
      return False

    left = 0
    right = len(matrix[row]) - 1
    while left <= right:
      mid = int((left + right)/2)
      if matrix[row][mid] == target:
        return True
      elif matrix[row][mid] < target:
        left = mid + 1
      else:
        right = mid - 1
    return False            
      
          
          
  def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    left = 0
    right = len(matrix) - 1

    while left <= right:
      mid = int((left + right)/2)

      if matrix[mid][0] == target:
        return True

      if matrix[mid][0] < target:
        if matrix[mid][len(matrix[mid]) - 1] >= target:
          return self.searchColumnsInRow(matrix, target, mid)
        else:
          left = mid + 1

      if matrix[mid][0] > target:
        right = mid -1    

        
obj = Solution()

matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 60
print(obj.searchMatrix(matrix, target))
        