# Time Complexity: O(1)
# Space Complexity: O(log n)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low=0
        n=len(matrix[0])
        high= (len(matrix) * len(matrix[0]))-1
        while low<=high:
            mid=(high+low)//2
            r=mid//n
            c=mid%n
            if matrix[r][c]==target:
                return True
            if matrix[r][c] > target:
                high=mid-1
            else:
                low=mid+1
        return False
        