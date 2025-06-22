# Time taken to solve the problem = 20 mins
# Time complexity - O(logmn)
# The 2-D array gets filled row wise. If flattended completely. It's a sorted list. Binary search on sorted list is straight forward.
# To get the co-ordinates of the mid element in the 2d array we need to use columns since the array is filled row wise. Dividing by cols gives x cords and mod by cols gives y cords.
# Since X is the nth part and y is the offest in the nth part.
class Solution:
    def get_cordinates(self, mid, rows, cols):
        co_ordinates_x = mid//cols
        co_oridnates_y = mid % cols
        return co_ordinates_x, co_oridnates_y

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])
        start = 0
        end = (rows*cols) -1
        while start <= end:
            mid = start + (end-start)//2
            x, y = self.get_cordinates(mid, rows, cols)
            print(matrix[x][y])
            if matrix[x][y] == target:
                return True
            if matrix[x][y] < target:
                start = mid+1
            else:
                end = mid - 1
        return False
            


        