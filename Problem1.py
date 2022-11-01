class Solution:
    def getMatrixRowsAndCols(self, matrix: List[List[int]]):
        return len(matrix), len(matrix[0])

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        totalRows, totalCols = self.getMatrixRowsAndCols(matrix)
        return self.binarySearch(matrix, target, 0, totalRows * totalCols)
        
    
    
    def binarySearch(self, twoDArr, target, low = 0, high = None):
        totalRows, totalCols = self.getMatrixRowsAndCols(twoDArr)
        
        if high == None:
            high = totalRows * totalCols
        
        while low < high:
            mid = (low + high) // 2
            midTwoD = self.oneToTwoDimIndexConverter(mid, totalRows, totalCols)
            twoDRow, twoDCol = midTwoD[0], midTwoD[1]
            if twoDArr[twoDRow][twoDCol] < target:
                low = mid + 1
            else:
                high = mid
                
        finalIndex = low
        if finalIndex >= totalRows * totalCols:
            return False
        finalTwoDIndex = self.oneToTwoDimIndexConverter(finalIndex, totalRows, totalCols)
        finalRow, finalCol = finalTwoDIndex[0], finalTwoDIndex[1]
        
        if twoDArr[finalRow][finalCol] == target:
            return True
        
        return False
            
            
    
        
    
    def oneToTwoDimIndexConverter(self, oneDIndex, totalRows, totalCols):
        row = oneDIndex // totalCols
        col = oneDIndex - (row * totalCols) #or oneDIndex % totalCols
        
        return [row, col]
        
        
    
        
        