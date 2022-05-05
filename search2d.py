'''
Time complexity: O(logn)
Space Complexity: O(1)
'''
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:\
        
        row = len(matrix)
        col = len(matrix[0])
        
        low = 0
        high = (row*col)-1
        
        while(low<=high):
            mid = low + (high-low)//2
            
            r = mid//col
            c = mid%col
            if(matrix[r][c]==target): return True
            
            if(matrix[r][c] > target):
                high = mid-1
            else:
                low = mid+1
        return False
        