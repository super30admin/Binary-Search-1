# // Time Complexity : O(logN)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if (matrix == None or len(matrix)==0):
            return False
        m = len(matrix) # number of rows
        n = len(matrix[0]) # number of columns
        low = 0
        high = m*n -1
        while(low<=high):
            mid = low + (high -low)//2
            
            row = int(mid/n)
            col = int(mid%n)
            
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] > target:
                high = mid -1 
            elif matrix[row][col] < target:
                low = mid +1
                
        return False
            
            
            
# Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
# Output: false           
            
        
        