# Time Complexity: O(log(n))
# Space Complexity: O(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        l=0        
        col=len(matrix[0])
        h=(len(matrix[0])*len(matrix))-1
        while(l<=h):
            m=l+(h-l)//2
            r=m//col
            c=m%col
            if matrix[r][c]==target:
                return True
            elif matrix[r][c]<target:
                l=m+1
            else:
                h=m-1
        return False