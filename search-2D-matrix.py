"""
https://leetcode.com/problems/search-a-2d-matrix/description/

The matrix looks like a row-wise flattened sorted 1D array. A “flattened sorted array” matrix is globally sorted when laid out as a 1D array from top-left to bottom-right.
--> Integers in each row are sorted left to right (or right to left).
--> The first integer of each row is greater than the last integer of the previous row.
We can treat it as a 1D array of m*n elements. 2D to 1D mapping -->
row = index // n (columns) --> How many full rows before this index as after every n elements, a new row starts
col = index % n  --> How far into that row

Column-wise flattened array will not have the pre-requisite where the first integer of each col is greater than the last integer of the previous col. So, it is not globally sorted when flattened and we cannot use binary search to find an element. 2D to 1D mapping -->
row = index % m (rows)
col= index // m

Time Complexity: O(logmn)
Space Complexity: O(1)
"""

class Solution:
  def searchMatrix(self, matrix, target):
    m = len(matrix)
    n = len(matrix[0])
    low = 0
    high = (m*n) - 1
    
    while low <= high: # searching for element, so include low == high, which means a single element list
      mid = (low + high)//2
      row = mid // len(matrix[0])
      col = mid % len(matrix[0])
      
      if matrix[row][col] == target:
        return True
      elif target > matrix[row][col]:
        low = mid + 1
      elif target < matrix[row][col]:
        high = mid - 1
    return False
    
       
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 3
sol = Solution()
print(sol.searchMatrix(matrix, target))