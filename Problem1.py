'''
Time Complexity : O(Log M + Log N)
Space Complexity : O(1)
'''


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m*n -1
        # assuming the whole matrix as a 1d array and then perofrming binary search on it 

        while(low<=high):
            mid = low + (high-low)//2
            row = mid//n
            col = mid%n
            #finding actual location in matrix
            if(matrix[row][col] == target):
                return True
            elif (matrix[row][col]>target):
                high = mid -1
            else :
                low = mid + 1
        return False