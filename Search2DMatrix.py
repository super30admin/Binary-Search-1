class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        m=len(matrix)
        n=len(matrix[0])
        t=m*n
        l=0
        r=t-1
        while l<=r:
            m_i=(l+r)//2
            i=m_i//n
            j=m_i%n
            mid=matrix[i][j]
            if target==mid:
                return True
            elif target<mid:
                r=m_i-1
            else:
                l=m_i+1
        return False


