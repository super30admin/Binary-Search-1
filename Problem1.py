# Problem1:Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
# Time Complexity: O(log(m * n)),We treat the whole matrix as one flattened sorted array of size m times n and do a single binary search over it. 
#So the search space is m times n and binary search takes log of that many steps.
# Space Complexity: O(1),We only use a few variables (low, high, mid, r, c), no extra data structures.
# Approach:
# Since each row is sorted and every row starts bigger than the previous row ends, the whole matrix behaves like one long sorted array if you read it left to right, row by row. 
#So instead of searching row by row, we can binary search directly over a virtual 1D array of length m times n.
# For any index in that virtual array, we can map it back to the actual row and column using division and modulo.

class Solution:
    def searchMatrix(self, matrix, target):
        m = len(matrix)  # number of rows in the matrix
        n = len(matrix[0])  # number of columns in the matrix

        low, high = 0, m * n - 1  # boundaries of the virtual flattened array

        while low <= high:  # standard binary search condition
            mid = low + (high - low) // 2  # middle index in the virtual flattened array
            r = mid // n  # convert the flat index back to the actual row number
            c = mid % n  # convert the flat index back to the actual column number

            if matrix[r][c] == target:  # if the value at this position is the target
                return True  # found it, return true
            elif matrix[r][c] > target:  # if the value is too big
                high = mid - 1  # search the left half of the virtual array
            else:  # otherwise the value is too small
                low = mid + 1  # search the right half of the virtual array

        return False  # if the loop ends without finding it, the target is not present