#Time Complexity : O(row + column)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :

#Your code here along with comments explaining your approach
#1. We eliminate numbers that are greater than our target
#2. Our row is the first element of the matrix and column is the last element of the first row

def searchMatrix(matrix, target):
        row = 0
        column = len(matrix[0]) - 1
        while row < len(matrix) and column >= 0:
            if matrix[row][column] > target:
                column -= 1
            elif matrix[row][column] < target:
                row += 1
            else:
                return True #or [row, column]
        return False  #or [-1, -1]


#matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
print(searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 13))
print(searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 16))
