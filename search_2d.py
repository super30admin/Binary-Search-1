# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
class Solution:
  def searchMatrix(self,matrix,target):
    start = 0
    end = len(matrix)
          
    if end == 0:
      return False
          
    while start < end:
      mid = (start + end) // 2
      s = 0
      e = len(matrix[mid])
          
      if e == 0:
        return False
              
      while s < e:
        m = (s+e)//2
        if matrix[mid][m] == target:
          print(True)
        elif matrix[mid][m] < target:
          s = m + 1
        else:
          e = m
              
      if matrix[mid][0] > target:
        end = mid
      elif matrix[mid][-1] < target:
        start = mid + 1
      else:
          return False
    return False
ob1 = Solution()
print(ob1.searchMatrix([[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], 72))