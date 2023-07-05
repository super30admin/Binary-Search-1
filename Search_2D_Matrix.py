class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        # to find the correct row
        row= 0
        for r in range(len(matrix)):
            if target== matrix[r][0] or target== matrix[r][-1]:
                return True
            elif target> matrix[r][0] and target< matrix[r][-1]:
                row= r
                break
        
        #to find the target in the row: binary search:
        l,r= 0, len(matrix[row])-1
        while l<=r:
            mid= l+(r-l)//2
            if target== matrix[row][mid]:
                return True
            elif target> matrix[row][mid]:
                l= mid+1
            else:
                r= mid-1
        
        return False




        