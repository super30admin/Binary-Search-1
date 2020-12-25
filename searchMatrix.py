#Time complexity = O(logm+logn) 
#space complexity= O(1) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if(matrix==[] or matrix==[[]]):
            return False
        else:
            l=0 
            m=len(matrix)# no of rows in matrix
            n=len(matrix[0])# no of columns in matrix
            while(l<m): #searching the target in the 1st column , if not found the middle element will show the row in which the target may be present
                middle_row=(l+m)//2
                if(matrix[middle_row][0]==target):
                    return True
                elif(matrix[middle_row][0]>target):
                    m=m-1
                else:
                    l=l+1
            l=0
            while(l<n):
                middle_column=(l+n)//2
                if(matrix[middle_row][middle_column]==target):
                    return True
                elif(matrix[middle_row][middle_column]>target):
                    n=n-1
                else:
                    l=l+1
            return False