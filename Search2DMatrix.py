#to search a matrix find no of rows and columns and loop over min to max point 
#if target is achieved return true if target value is more than matrix value search on right side
#if target is less than matrix value search on left side of matrix
#because of this technique time complexity is 0(log(m*n))
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix==None or matrix==0:
            return False
        
        m=len(matrix)
        n=len(matrix[0])
        low=0
        high=m*n-1

        while low<=high:
            mid=low+(high-low)//2
            row=mid//n
            col=mid%n

            if(target==matrix[row][col]):
                return True
            elif target>matrix[row][col]:
                low=mid+1
            else:
                high=mid-1
        return False