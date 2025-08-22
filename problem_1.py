class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool: # log(m*n)
        """Assume 2d array as a array and applied binary search on it
        """
        m=len(matrix)
        n=len(matrix[0])

        low=0
        high = m*n-1

        while low<=high:
            mid=low+(high-low)//2
            r=mid//n
            c=mid%n
            if matrix[r][c]==target:
                return True
            elif target<matrix[r][c]:
                high=mid-1
            else:
                low=mid+1
        return False 