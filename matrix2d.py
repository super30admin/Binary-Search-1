class Solution:

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for i in range(len(matrix)):
            l=0
            h=len(matrix[i])-1
            while l<=h:
                mid=l+(h-l)//2
                if(matrix[i][mid]==target):
                  return True
                elif (matrix[i][mid]<target):
                  l=mid+1
                else:
                   h=mid-1
        return False
                
                    

matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
target = 5

obj = Solution()
obj.searchMatrix(matrix, target)
