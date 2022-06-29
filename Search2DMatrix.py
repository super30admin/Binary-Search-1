# Time Complexity : 58
#  Space Complexity : 14.4
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        #Define inner array length
        m = len(matrix[0])

        #Declaring left and right to set lower and upper bound
        left = 0
        right = m * len(matrix) -1

        #Do binary search till you find the index desired        
        while left <= right:

            mid = left+ (right-left)//2
            
            #row to choose a outer array index based on mid
            row = mid // m
            # column to choose the nested array index based on mid
            col = mid % m

            #If target exist returen True else adjust the left and right based on value acquired           
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] > target:
                right = mid - 1
            else:
                left = mid + 1
        return False