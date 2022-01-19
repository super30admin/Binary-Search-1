## Problem1 
# Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        if not matrix:
            return False
        
        def ele_index(m,n,index):
            if index==0:
                return 0,0
            row = index//n
            col = index%n
            # print(f"matrix element at {index}, {row},{col}:",matrix[row][col])
            return row, col
        
        m = len(matrix)
        n = len(matrix[0])
        total = (m*n)-1
        
        low = 0
        high = total
        while(low<=high):
            mid = low+(high-low)//2
            row,col = ele_index(m,n,mid)
            #base case
            if(matrix[row][col] == target):
                return True
            elif(target>matrix[row][col]):
                low = mid+1
            else:
                high = mid-1
        return False
            
            
        
