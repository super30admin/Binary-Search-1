
# time complexity - O(log(m*n))
# space complexity - O(1)


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        if not matrix or len(matrix)==0:
            return False

        m=len(matrix)
        n=len(matrix[0])
        start=0
        end=m*n-1        

        while(start<=end):
            mid=start+(end-start)//2
            row=mid // n#for row lookup
            col=mid % n  #for column lookup
            if matrix[row][col]==target:
                return True
            elif target<matrix[row][col]:
                end=mid-1
            else:
                start=mid+1
        return False
