#Time complexity: O(M+N) M and N denote number of rows and columns
#Space complexity: O(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        i=0
        j=len(matrix[0])-1
        while i<len(matrix) and j>=0:
            #Checking if we found our target
            if matrix[i][j]==target:
                return True
            elif matrix[i][j]>target:
                #It means the values below are greater than the target and hence cn be ignored
                j=j-1
            elif matrix[i][j]<target:
                #It means the values to the left are smaller and can be ignored.
                i=i+1
        return False