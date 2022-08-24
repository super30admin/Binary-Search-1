class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        def binarySearch(arr, low, high, target):
            while low <= high:
                mid = (low + high) // 2
                if arr[mid] == target:
                    return True
                elif target > arr[mid]:
                    low = mid + 1
                else:
                    high = mid - 1
            return False
        
        rows = len(matrix)
        columns = len(matrix[0])
        #if it exceeds then false
        if target > matrix[rows - 1][columns - 1] and target < matrix[0][0]:
            return False
        
        #search goes here
        for index in range(rows):
            if index == rows - 1:
                return binarySearch(matrix[index], 0, len(matrix[index]) - 1, target)
            elif index != rows-1 and target >= matrix[index][0] and target < matrix[index + 1][0]:
                return binarySearch(matrix[index], 0, len(matrix[index]) - 1, target)
        return False