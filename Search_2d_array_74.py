# Since the elements are sorted left to right, we can perform binary search
# Time: O(log(m*n)) m and n are number of row and col
# Space: O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row,col = len(matrix),len(matrix[0])
        l,r=0,row*col-1

        # Performing binary search
        while l <= r:
            mid = (l+r) //2 
            rowIndex = mid // col
            colIndex = mid % col
            if matrix[rowIndex][colIndex] == target:
                return True
            elif matrix[rowIndex][colIndex] > target:
                r = mid -1
            else:
                l = mid+1
        return False
        
