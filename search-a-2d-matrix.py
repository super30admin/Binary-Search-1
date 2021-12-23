class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        def binarySearch(target, row):
            left, right = 0, len(row)-1
            while left <= right:
                mid = (left + right)//2
                if row[mid] == target: return True
                elif row[mid] < target: left = mid + 1
                else: right = mid - 1
            return False

        def arrSearch(target, search_arr):
            left, right = 0, len(search_arr)-1
            while left <= right:
                mid = (left+right)//2
                if search_arr[mid] <= target: left = mid+1
                else: right = mid-1
            return right

        # search_arr = [row[0] for row in matrix]
        # searcher_index = arrSearch(target, search_arr)
        return binarySearch(target, matrix[arrSearch(target, [row[0] for row in matrix])])