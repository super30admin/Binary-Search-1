#Time-Complexity: O(logn)
#Space-Complexity: O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        lo=0
        m=len(matrix)
        n=len(matrix[0])
        hi=m*n-1
        
        while lo<=hi:
            mid=lo+(hi-lo)//2
            mid_element=matrix[mid//n][mid%n]
            if mid_element==target:
                return True
            elif target>mid_element:
                lo=mid+1
            else:
                hi=mid-1
                
        return False