# first we find the correct row 
# then we see target < smallest value in middle row or target > biggest value in middle row
# once row established do 1d binary search to find correct element


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m,n = len(matrix)-1,len(matrix[0])-1

        rowstart,rowend=0,m

       
        
        colStart,colEnd=0,n


       

        
        while(rowstart <= rowend):
            rowmid = rowstart + (rowend - rowstart)//2
            if(target < matrix[rowmid][0]):
                rowend = rowmid - 1
            if(target > matrix[rowmid][-1]):
                rowstart = rowmid + 1
            else:
                break
        
        if not (rowstart <= rowend):
            return False
      
        

        while( colStart <= colEnd ):
            colMid = colStart + (colEnd - colStart)//2
            if(target < matrix[rowmid][colMid]):
                colEnd = colMid - 1
            if(target > matrix[rowmid][colMid]):
                colStart = colStart + 1
            if(target == matrix[rowmid][colMid]):
                return True
        
        return False
