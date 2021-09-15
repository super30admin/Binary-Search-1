# Time complexity: O(log n)
# Space complexity: O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

'''
for this question, one brute force approach is to read through the matrix and create a 1D array and perform binary search on it. That would incur (n^2 * log n) time complexity.
An optimal approach is to consider the matrix as 1D array and perform operations accordingly
'''


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rowLen = len(matrix)
        colLen = len(matrix[0])
        # mark pointers same was you'd mark for 1D array
        left, right = 0, (rowLen)*(colLen)-1

        while left <= right:
            mid = (left+right)//2
            # after calculating the mid find the corresponding index in the matrix and then perform the regular binary search
            matrixValue = self.getMatrixValue(mid, matrix, colLen)
            if matrixValue == target:
                return True
            if matrixValue < target:
                left = mid+1
            else:
                right = mid-1

        return False

    def getMatrixValue(self, index, matrix, colLen):
        # calculate the row and col indices and return the matrix element in that index
        row = index//colLen
        col = index % colLen
        return matrix[row][col]


solution = Solution()
print(solution.searchMatrix(
    [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 20))
print(solution.searchMatrix(
    [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 202))
