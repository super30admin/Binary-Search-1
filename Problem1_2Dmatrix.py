'''
Time Complexity: O(logmn)
Space Complexity: O(1)
Implemented Successfully
'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if(matrix == None or len(matrix) == 0):
            return False
        m, n = len(matrix), len(matrix[0])
        low, high = 0, (m*n)-1
        while (low <= high):
            mid = low + (high - low)//2
            row = mid//n
            col = mid%n
            if(matrix[row][col] == target):
                return True
            elif(matrix[row][col] < target):
                low = mid+1
            elif(matrix[row][col] > target):
                high = mid-1
            else:
                return False