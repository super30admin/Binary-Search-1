#Time Complexity : O(log(mn))
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        #print(len(matrix))
        row = len(matrix)
        col = len(matrix[0])
        low = 0
        high = row*col-1
        while low <= high:
            mid = low + (high - low)//2
            r = mid //col
            c = mid % col
            if matrix[r][c] == target:
                return True
            if matrix[r][c] > target:
                high = mid - 1
            else:
                low = mid + 1
                
        return False
            
            
            
                
            
            
                