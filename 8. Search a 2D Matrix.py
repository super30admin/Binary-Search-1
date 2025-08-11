class Solution:
    # First, we are performing a binary search on the last elements of each row to find the potential row where the target could be.
    # Then, we are performing a binary search within that row to check if the target exists.
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        low, high = 0, m - 1

        while low <= high:
            mid = low + (high - low) // 2
            if matrix[mid][n - 1] == target:
                return True
            elif matrix[mid][n - 1] < target:
                low = mid + 1
            else:
                high = mid - 1

        if low >= m:
            return False

        # Now, we are searching for the target in the identified row using binary search.
        return self.binarySearch(matrix[low], target)

    def binarySearch(self, row, target):
        # We are performing a standard binary search on the row.
        low, high = 0, len(row) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if row[mid] == target:
                return True
            elif row[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return False
# Time Complexity: O(log M + log N), where M is the number of rows and N is the number of columns.
# Space Complexity: O(1), only one constant amount of extra space is being used.