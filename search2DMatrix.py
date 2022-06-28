# Time Complexity = O(logn) + O(logm) = O(log m*n)
# Space Complexity = O(1)

class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        
        if len(matrix) == 0 or matrix == None:
            return False
        
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m * n - 1 

        while low <= high:
            mid = low + ((high-low)//2)
            # Since we are flattening the 2D array into 1D array and n(no. of cols) elements are bunched together for each row m
            row = mid // n      
            col = mid % n
            # If target is smaller than the mid element, we move towards the left side of 1D array
            if target < matrix[row][col]:
                high = mid - 1
            # If target is larger than the mid element, we move towards the right side of 1D array
            elif target > matrix[row][col]:
                low = mid + 1
            # If target is equal to mid element
            else:
                return True
            
        
        
        