class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        def binsearch(arr, target):
            l = 0
            r = len(arr) - 1
            while l <= r:
                mid = l + int((r - l)/2)
                if target == arr[mid]:
                    return True
                elif target > arr[mid]:
                    l = mid + 1
                else:
                    r = mid - 1
            return False
        for i in matrix:
            if target >= i[0] and target <= i[len(i) - 1]:
                return binsearch(i, target)
            else:
                continue
        return False