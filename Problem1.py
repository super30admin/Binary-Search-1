// Time Complexity : O(log m + log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        # first binary search for rows
        low = 0
        high = m-1
        while(low<=high):
            mid = low + (high - low)//2
            if matrix[mid][0]<=target and matrix[mid][n-1]>=target:
                break
            elif matrix[mid][0]<target:
                low = mid+1
            elif matrix[mid][0]>target:
                high = mid-1
        row = mid
        #second binary search for columns
        low=0
        high=n-1
        while(low<=high):
            mid=low + (high - low)//2
            if matrix[row][mid] == target:
                return True
            elif matrix[row][mid] > target:
                high = mid-1
            else:
                low = mid+1
        return False