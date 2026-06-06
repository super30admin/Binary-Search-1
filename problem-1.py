# SEARCH A 2D MATRIX
# TIME COMPLEXITY: O(log N*M) where N denotes the rows and M denotes the columns 
# SPACE COMPLEXITY: O(1)
# Any problem you faced while coding this : Had some hiccup while writing the calc_row and
# calc_col code as I knew the concept but hadsome error in implementation
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        low=0
        row=len(matrix)
        col=len(matrix[0])
        high=row*col-1
        while low<high:
            mid=(high+low)//2
            calc_row=mid//col
            calc_col=mid%col
            if matrix[calc_row][calc_col]==target:
                return True
            elif matrix[calc_row][calc_col]<target:
                low=mid+1
            else:
                high=mid
        final_row=low//col
        final_col=low%col
        return matrix[final_row][final_col]==target
