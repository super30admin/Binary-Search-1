#  Search a 2D Matrix

class Solution:
    def searchMatrix(self, matrix, target):
        # Time complexity = log(n) + m
        # Space complexity = O(1); because no auxillary data is stored

        low = 0
        inner_matrix_length = len(matrix[0])-1
        high = len(matrix) - 1
        while(high >= low):
            mid = (low + high)//2
            if target >= matrix[mid][0] and target <= matrix[mid][inner_matrix_length]:
                break;
            
            if matrix[mid][0] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        if target in matrix[mid]:
            return True
        return False
