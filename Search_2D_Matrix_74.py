## Problem1 - Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)


# Time Complexity: O(log(m*n))  -- Since we are converting into an imaginary 1d array and doing binary search on it.
# Space Complexity: O(1) - No extra space used
# Leetcode Problem solved successfully?: Yes
# Code:
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        m = len(matrix)
        n = len(matrix[0])  
        # Since the minimum length will be 1,not checking base condition
        
        low = 0
        high = m*n-1
        
        while(low<=high):
            mid = low + (high - low) // 2 # To avoid integer overflow
            row = mid // n
            column = mid % n
            if matrix[row][column] == target:
                return True
            elif matrix[row][column] < target:
                low = mid + 1
            else:
                high = mid - 1
        
        return False

# Approach: We create an imaginary array of the same size and apply a binary search on it. 
#           To accuartely locate the column and the row properly we use 2 hash functions and check if the target is greater than current mid 
#           1. if it is greater then we do low = mid + 1 else we do high = mid - 1