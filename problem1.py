class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m=len(matrix)
        n=len(matrix[0])
        left=0
        right=m*n-1
        
        while(left<=right):
            pivot=(left+right)//2
            #row number pivot/n
            #col pivot%n
            if (matrix[pivot//n][pivot%n]==target):
                 return True
            elif (matrix[pivot//n][pivot%n]<target):
                left=pivot+1
            else:
                right=pivot-1
        return False
    #time complexity: O(log n)
    #space: o(1)
    #Leetcode : https://leetcode.com/submissions/detail/512711913/
