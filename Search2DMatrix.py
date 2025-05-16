# // Time Complexity : Approach 1 and 2 o(log(m*n))
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :
#   could solve using binary search twice faced on the 2D didnt solve using convert 2d to 1d
#  form approach 1 faced issues while calculating mid using l+ (h-l)//2


# // Your code here along with comments explaining your approach in three sentences only
#  1) For Approach 1 - find the target row with binary search so compare the last element for greater case and smallest element for other case and then apply binary search of that row
# 2) for approach 2 - consider the 2D matix as the 1d matrix without creating a flat array , apply binary search by using correct row and column index 
# 3) for approach 2 - if sizee of matrix 5*5 total elements 0,24 and row index = mid/number of columns and column index = mid%columns

# Approach 2 :
from typing import List
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row , col = len(matrix) , len(matrix[0])
        l,h = 0,(row*col)-1
        while l<=h:
            mid = l + (h-l//2)
            rowIndex = mid//col
            colIndex = mid%col
            if matrix[rowIndex][colIndex] > target:
                h = mid -1
            elif matrix[rowIndex][colIndex] < target:
                l = mid +1
            else:
                return True
        return False

# Approach 1:
#  class Solution:
#     def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
#         top, bottom = 0, len(matrix) -1
#         while top<=bottom:
#             row = (top + bottom)//2
#             if matrix[row][-1] < target:
#                 top = row+1
#             elif matrix[row][0] > target:
#                 bottom = row-1
#             else:
#                 break
#         l,h = 0, len(matrix[row])-1
#         while l<=h:
#             mid = l+(h-l//2)
#             if matrix[row][mid] == target :
#                 return True
#             elif matrix[row][mid] > target:
#                 h = mid -1
#             else:
#                 l = mid+1
#         return False

            


        

