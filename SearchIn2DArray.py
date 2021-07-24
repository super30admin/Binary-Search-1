#Time COmplexity O(log mn) where m and n are dimetions of the 2d array
#space complexity O(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        R = len(matrix)
        C = len(matrix[0])
        low = 0
        high = R*C-1
        while(low<=high):
            mid = low + (high-low)//2
            r = mid//C
            c = mid % C
            if matrix[r][c] == target:
                return True
            if target>matrix[r][c]:
                low = mid+1
                print(low)
            else:
                high = mid-1
                
        return False