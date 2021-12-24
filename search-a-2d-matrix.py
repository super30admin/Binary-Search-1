class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """

# Time Complexity: O(log(mn))
        def convert1d2d(val):
            n = len(matrix[0])
            m = len(matrix)
            return val//n, val%n

        if not matrix: return False
        low = 0
        n = len(matrix[0])
        m = len(matrix)
        high = (m*n)-1
        while (low <= high):
            mid = (low+high)//2
            row, col = convert1d2d(mid)
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] > target:
                high = mid - 1
            else:
                low = mid + 1
        return False

# TimeComplexity: O(logm+logn)
#         def binarySearch(target, row):
#             left, right = 0, len(row)-1
#             while left <= right:
#                 mid = (left + right)//2
#                 if row[mid] == target: return True
#                 elif row[mid] < target: left = mid + 1
#                 else: right = mid - 1
#             return False

#         def arrSearch(target, search_arr):
#             left, right = 0, len(search_arr)-1
#             while left <= right:
#                 mid = (left+right)//2
#                 if search_arr[mid] <= target: left = mid+1
#                 else: right = mid-1
#             return right

#         # search_arr = [row[0] for row in matrix]
#         # searcher_index = arrSearch(target, search_arr)
#         return binarySearch(target, matrix[arrSearch(target, [row[0] for row in matrix])])