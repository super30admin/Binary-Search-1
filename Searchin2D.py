#Time complexity: O(logm+logn)
#Space Complexity: O(1)
class Solution:
    def searchMatrix(self, matrix, target):
        lowRow=0
        highRow=len(matrix)-1
        while lowRow<=highRow:
            midRow=(lowRow+highRow)//2
            print(lowRow,highRow,midRow)
            if target >= matrix[midRow][0] and target<=matrix[midRow][-1]:
                break
            elif target<matrix[midRow][0]:
                highRow=midRow-1
            else:
                lowRow=midRow+1
        if lowRow>highRow:
            return False
        lowCol=0
        highCol=len(matrix[0])-1
        a=matrix[midRow]
        while lowCol<=highCol:
            midCol=(lowCol+highCol)//2
            if target==a[midCol]:
                return True
            elif target<a[midCol]:
                highCol=midCol-1
            else:
                lowCol=midCol+1
        return False
        