class Solution:
    #binary search approach
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix==None and len(matrix)==0:
            return False
        
        m=len(matrix)
        n=len(matrix[0])
        low=0
        high=m*n-1
        while low<=high:
            mid=low+(high-low)//2
            row=mid//n #each row has n elements
            col=mid % n #every col will range bet 0 to n
            if matrix[row][col]==target:
                return True
            elif target<matrix[row][col]:
                high=mid-1
            else:
                low=mid+1
        
        return False

#time complexity= 0(log(m*n))
#space complexity=0(1)