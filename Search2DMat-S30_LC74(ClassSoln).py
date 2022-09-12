# Elements sorted in each row and between rows as well, so binary search can be applied.
# Leetcode submission successful
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """

        # Time Complexity: O(log(N)) (logarithmic because of Binary search)
        # Space Complexity: Constant or O(1)
        lo = 0
        n_rows = len(matrix)
        n_cols = len(matrix[0]) # no. of elements in first row
        hi = n_rows * n_cols - 1

        # lo > hi is when index out of bound error will come. Shouldn't encounter this.
        while lo <= hi: # traditional binary search condition check

            # to avoid int overflow
            mid = lo + int((hi - lo) / 2)

            # floor division by n_cols gives us the row in which element is present
            row = int(mid / n_cols)

            # modulus with n_cols gives us the specific element in the row we got
            col = mid % n_cols

            if matrix[row][col] == target:
                return True

            # the 2 other binary search traditional conditions
            elif matrix[row][col] > target:
                hi = mid - 1
            elif matrix[row][col] < target:
                lo = mid + 1
        return False