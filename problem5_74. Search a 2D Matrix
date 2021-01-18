class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if(not matrix or not matrix[0]):
            return False;
        nrows, ncols = len(matrix), len(matrix[0]);
        r,c = 0, len(matrix[0]) - 1
        
        while(0<=r<nrows and  0<=c<ncols):
            if(matrix[r][c] == target):
                return True;
            elif(target < matrix[r][c]):
                c -=1;
            else:
                r += 1;
        return False;
        
