class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        row = len(matrix)
        
        if row == 0:
            
            return False
        
        col = len(matrix[0])
        
        left, right = 0, row * col - 1
        
        
        
        # print(left, right)
        
        while(left <= right):
            
            pivot_idx = (left + right) // 2
            
            pivot_ele = matrix[pivot_idx//col][pivot_idx%col]
            
            # print(pivot_ele)
            
            if pivot_ele == target:
                
                return True
                
            else:
            
                if target < pivot_ele:
                
                    right = pivot_idx - 1
                
                else:
                
                    left = pivot_idx + 1
        
        return False
