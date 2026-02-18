#Search a 2D Matrix

#Space complexity O(1), Time complexity O(log(m) + log(n))
#Binary search on 1st column of rows will be used to identify which row target can be present
#Binary search on that row will tell if target is present or not

class Solution:
#     def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

#         # edge case checks
#         if matrix[0][0] > target:
#             return False
        
#         if matrix[len(matrix)-1][len(matrix[0])-1] < target:
#             return False

#         #1st for the input using binary search found which row does the number belongs using 1st column of each row
#         rowLow = 0
#         highRow = len(matrix) - 1

#         while (rowLow<highRow):
#             mid  = (rowLow+highRow)//2 + 1
#             # if we found target return true
#             if matrix[mid][0] == target:
#                 return True

#             if target < matrix[mid][0] :
#                 # target is before the mid
#                 highRow = mid - 1
#             else:
#                 rowLow  = mid

#         # once and high are equals means we found the row in which the target can lie

#         # now binary search on that row

#         lowC  = 0
#         highC = len(matrix[rowLow]) - 1

#         while lowC <= highC:
#             mid = (lowC + highC)//2
#             if matrix[rowLow][mid] == target:
#                 return True
#             if target < matrix[rowLow][mid] :
#                 highC = mid -1
#             else:
#                 lowC = mid + 1
        
#         return False

# This solution is more cleaner however, might be a bit slower due to the extra mathematical computations
# The time complexity for both will be O(log(m*n))

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # assuming it is a long array just place in 2d patrix
        left = 0
        right = len(matrix) * len(matrix[0]) - 1
        rowLength = len(matrix[0])
        while left<=right:
            mid = (left+right)//2
            #Now we need to find where in the 2d matrix this mid will be present
            #if we take the length of 1st row, devision with that should give us the row number
            #while modulus will give the column
            row = mid // rowLength
            column = mid % rowLength
            element = matrix[row][column]
            print("left is {}, right is {}, mid is {}, row is {}, column is {} and element at mid is {}".format(left, right, mid, row, column,element))
            if element == target:
                return True
            
            if target >= matrix[row][column] :
                left = mid + 1
            else:
                right = mid - 1
        return False