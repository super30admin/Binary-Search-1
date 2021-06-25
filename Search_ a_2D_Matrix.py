class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low = 0
        high = len(matrix)-1
        n_col = len(matrix[0])
        row = 0
        while(low<=high):
            mid = (low+high)//2
            if matrix[mid][n_col-1]>=target:
                row = mid
                high = mid-1
            else:
                low = mid+1
        low = 0
        high = n_col-1
        while(low<=high):
            mid = (low+high)//2
            if matrix[row][mid]==target:
                return True
            elif matrix[row][mid]>target:
                high = mid-1
            else:
                low = mid +1
        return False
#Time Complexity: O(logM +logN)
#Space complexity : O(1)