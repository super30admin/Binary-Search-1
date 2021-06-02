"""
Nearest Binary Search on 1st Row followed by Binary Search on Column
Time Complexity : O(log(m) + log(n)) where m - number of rows and n - number of columns.
Space Complexity : O(1)

"""

class Solution:
    def bin_col(self, arr, l, h, target):
        
        while l <= h:
            mid = l + (h-l)//2
            
            if (mid == len(arr) - 1 or arr[mid+1][0] > target) and (target >= arr[mid][0]):
                return mid 
    
            elif arr[mid][0] < target:
                l = mid + 1 
            
            else:
                h = mid - 1 
                
        return -1
    
    def bin_row(self, arr, l, h, target):
        
        while l <= h:
            mid = l + (h-l)//2
            
            if arr[mid] == target:
                return True
            
            elif arr[mid] < target:
                l = mid + 1 
            
            else:
                h = mid - 1 
        return False 
        
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix) - 1 
        n = len(matrix[0]) - 1 
        
        l = 0
        h = m 
        
        row = self.bin_col(matrix, l, h, target)
        print(row)
        if matrix[row][0] == target:
            return True 
        elif row == -1:
            return False 
        
        l1 = 0
        h1 = n 
        
        return self.bin_row(matrix[row], l1, h1, target)
        

