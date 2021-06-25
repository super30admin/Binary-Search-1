# Time complexity - O(logn)
# Space complexity - 
class Solution(object):
    """
    We will first flatten the matrix into a list and then 
    Perform a binary search on the list to find the target element

    index = rows*numberOfColumns + Columns is the formula used to get the index by JVM
    rows = mid / cols
    cols = mid % cols
    Args:
        object ([type]): [description]
    """
    
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if len(matrix) is 0 or matrix is None:
            return False
        
        rows_m = len(matrix)
        columns_n = len(matrix[0])

        low = 0                        # low = 0
        high = (rows_m*columns_n) - 1  # high = 11
        
        while low <= high:
            mid = low + (high-low)/2      # mid = 0 + (11-0)/2 = 11/2 = 5 ; mid is on the 5th index
            row = mid / columns_n         # row = 5/4 = 1 ; mid is in the 1st row
            column = mid % columns_n      # column = 5%4 = 1; mid is in the 1st column of that row

            if matrix[row][column] == target:
                return True
            elif matrix[row][column] >= target:
                high = mid - 1
            else:
                low = mid +1
                
        return False