# Time Complexity : It is O(log m*n) since we dividing the length in each iteration. 
# Space Complexity : There is no extra space so it O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        Low = 0
        High = len(matrix)*len(matrix[0])-1
        
        while(Low<=High):
            Mid = Low + (High-Low)//2
            
            LowRow = Low//len(matrix[0])
            LowCol = Low%len(matrix[0])
            
            HighRow = High//len(matrix[0])
            HighCol = High%len(matrix[0])
            
            MidRow = Mid//len(matrix[0])
            MidCol = Mid%len(matrix[0])
            
            if(matrix[LowRow][LowCol]<= target and target<= matrix[MidRow][MidCol]):
                High=Mid -1
            else:
                Low=Mid +1
                
            if(matrix[LowRow][LowCol]==target or matrix[MidRow][MidCol] == target or matrix[HighRow][HighCol] == target):
                return True
        return False
         
        
        
obj = Solution()
print(obj.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]],3))