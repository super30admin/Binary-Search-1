class Solution:
    # Time complexity - O(log (m * n)) where m is number of rows and n is number of columns
    # Space complexity - O(1)

    # treating 2D matrix as a flattened sorted array
    # apply binary search on the virtual 1D array
    # convert 1D mid index to 2D using row = mid // n and col = mid % n
    # compare pivot_val with target and adjust search range
    # return True if target found, else return False

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low = 0
        high = len(matrix) * len(matrix[0]) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            pivot_val = matrix[mid // len(matrix[0])][mid % len(matrix[0])]

            if pivot_val == target: return True
            elif pivot_val > target:
                high = mid - 1
            else:
                low = mid + 1
        return False
