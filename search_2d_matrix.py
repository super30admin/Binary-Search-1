"""Iterate each row and see if the target is equal to the last element of that row and return True if so.
Or else if the target is less than the last element of the row, target may lie in that row.
Do a binary search on that row and return True or False.
Time complexity will be O(m * logn). Space complexity will be  O(1) since no extra space"""

"""This can also be done in O(log m*n) by assuming the matrix as an imaginary 1D array and matching
corresponding indices between array and matrix"""


# Solution 1
class Solution:
    def _binary_search(self, row, target) -> bool:
        low, high = 0, len(row) - 1

        while low <= high:
            mid = low + (high-low) // 2
            mid_element = row[mid]

            if mid_element == target:
                return True  # Element found
            elif mid_element < target:
                low = mid + 1
            else:
                high = mid - 1
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for row in matrix:
            if target == row[-1]:
                return True
            elif target < row[-1]:
                if self._binary_search(row, target):
                    return True

        return False
    
# Solution 2
    """Assume the given matrix as an imaginary 1D array and for each mid, get the corresponding row,col
    position of each and check if it is target or if not which half to keep and repeat the binary search.
    Time complexity will be O(log m*n)
    Space Complexity will be O(1) """
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low, high = 0, len(matrix) *len(matrix[0])-1
        while(low<=high):
            mid = low + (high-low)//2
            orig_mid = (mid//len(matrix[0]), mid%len(matrix[0]))
            if matrix[orig_mid[0]][orig_mid[1]] == target:
                return True
            if target <= matrix[orig_mid[0]][orig_mid[1]]:
                high = mid-1
            else:
                low = mid+1
        return False