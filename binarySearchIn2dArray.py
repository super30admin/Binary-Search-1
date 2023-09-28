class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        def binarySearch(arr, target):
            lo, hi = 0, len(arr)-1
            while lo<=hi:
                mid = lo + ((hi-lo)//2)
                if target == arr[mid]:
                    return True
                if target < arr[mid]:
                    hi = mid-1
                else:
                    lo = mid+1
            return False

        i,j = 0, len(matrix)-1
        while (i<=j):
            mid = (i+j)//2
            if target < matrix[mid][0]:
                j = mid -1
            elif target >matrix[mid][len(matrix[0])-1]:
                i = mid + 1
            else:
                return binarySearch(matrix[mid], target)
        return False