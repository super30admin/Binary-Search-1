# Considering the entire array to be 1D array since we know that
# "The first integer of each row is greater than the last integer of the previous row"
# Since it is list now, binary search as being applied by dividing the list iteratively and searching for target

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        rows, cols = len(matrix), len(matrix[0])
        low = 0
        high = rows * cols - 1

        while(low<=high):
            mid = (low + high) // 2
            row = mid // cols
            col = mid % cols
            value = matrix[row][col]

            if value == target:
                return True
            elif value > target:
                high = mid-1
            else: 
                low = mid+1

        return False