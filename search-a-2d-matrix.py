#TC:O(log m*n) SC:O(1)
#binary search

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m=len(matrix)
        n=len(matrix[0])
        L=0
        R=m*n-1 #11

        while L<=R:
            mid=(L+R)//2 #5
            row = mid // n #1
            column = mid%n #1
            print(row,column)
           
            if target < matrix[row][column]:
                R=mid-1 
            elif target>matrix[row][column]:
                L=mid+1
            elif target==matrix[row][column]:
                return True
       
        return False
