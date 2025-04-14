class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix == None or len(matrix) == 0:
            return False
        m,n = len(matrix),len(matrix[0])
        left,right = 0, (m*n)-1
        while left <= right:
            mid = (left+right)//2
             # Map the middle index to the corresponding row and column in the 2D matrix.
            row = mid // n
            col =  mid % n
            # return True if we find target
            if matrix[row][col] == target:
                return True
            # If the middle element is less than the target narrow the search to right part
            elif matrix[row][col] < target:
                left = mid +1
            # If the middle element is greater than the target narrow the search to left part
            else:
                right = mid -1
        return False
# TC : O(log(m*n))
# SC : O(1)