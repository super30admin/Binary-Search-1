#Consider the matrix to be a 1D array and then get the row and column of the mid value so as to continue searching as it is a matrix
#The time complexity will be O(log mxn) as Binary Search is being done taking the number of elements to be mxn.
#Space complexity will be O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if(matrix==None):
            return False
        m=len(matrix)
        n=len(matrix[0])
        low=0
        high=m*n-1
        while(low<=high):
            mid=low+(high-low)//2
            row=mid//n
            column=mid%n
            if(target==matrix[row][column]):
                return True
            elif (target<matrix[row][column]):
                high=mid-1
            else:
                low=mid+1
        return False
        