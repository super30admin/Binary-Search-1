
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        h = len(matrix)
        w = len(matrix[0])
        
        l = 0
        r = h * w - 1
        
        while l <= r:
            m = l + (r - l) // 2
            
            i, j = m // w, m % w
            
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] < target:
                l = m + 1
            else:
                r = m - 1
        
        return False
    

    # T.C. = O(log(nm))
