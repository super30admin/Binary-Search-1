"""
# Approach
Assuming this 2d matrix as an 1D array,
calucalted row and column using the mid and performed  regular binary sort 

# Complexity
- Time complexity:
O(log(m*n))

- Space complexity:
O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : took some time to calculate row and column value from mid value
"""

class Solution:
    def searchMatrix(self, matrix, target):
        m,n = len(matrix), len(matrix[0])   #assigning no.of rows and columns to m,n
        start = 0
        end = m*n - 1
        while (start <= end):
            mid = start + (end - start) // 2
            row,column = mid // n, mid % n #calculating row,column of the mid element
            if (matrix[row][column] == target ): #if mid equals target returning True
                return True
            elif(matrix[row][column] < target): # if target in the right side, changing the start value
                start = mid + 1
            else: # else changing the end value
                end = mid -1
        return False    #if target doesnt matches any value return false
    
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 3
matrix1 = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target1 = 13
sol = Solution()
print(sol.searchMatrix(matrix,target))
print(sol.searchMatrix(matrix1,target1))