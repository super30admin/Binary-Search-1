# Problem 1: Search a 2D Matrix (https://leetcode.com/problems/search-a-2d-matrix/)

# Time Complexity: O(log(m*n)) where m is the number of rows and n is the number of columns
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# We treat the 2D matrix as a 1D sorted array and perform binary search.
# We calculate the mid index and convert it back to 2D indices to access the matrix elements.


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or len(matrix[0])==0:
            return False
        
        m = len(matrix)
        n = len(matrix[0])

        low = 0
        high = m*n-1
        while low <= high:
            mid = low + (high - low)//2
            r = mid//n
            c = mid%n

            if matrix[r][c] == target:
                return True
            
            elif target < matrix[r][c]:
                high = mid -1

            elif target > matrix[r][c]:
                low = mid +1 
                
        return False