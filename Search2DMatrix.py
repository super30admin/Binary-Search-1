# Time Complexity : O(logm*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        nrows = len(matrix)
        ncols = len(matrix[0])
        low = 0
        high = (nrows*ncols)-1
        while low<=high:
            mid = low+ (high-low)//2
            r_idx = mid//ncols
            c_idx = mid%ncols
            if matrix[r_idx][c_idx]==target:
                return True
            elif matrix[r_idx][c_idx]<target:
                low = mid+1
            else:
                high = mid-1
        return False