"""
Intuition: We imagine (NOT CONVERT!) the given 2D array to be a 1D array.
We apply binary search as usual. 

For getting mid indxes in 2D, we convert the obtained mid index in 1D to 2D with the help of the number of columns.
#####################################################################
Time Complexity : O(log (m*n)) where m = number of rows, n = number of cols
Space Complexity : O(1)
#####################################################################

"""

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    
        rows = len(matrix)
        cols = len(matrix[0])
        low = 0 
        high = (rows * cols) -1
        
        #Binary Search
        while low <= high:
            
            mid = (low + high) //2
            #Converting the 1D mid value, to 2D
            r = mid // cols
            c = mid % cols
            
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                high = mid - 1
            
            elif matrix[r][c] < target:
                low = mid + 1
        return False
            
            