def binarySearchMatrix(matrix, l, r, target):
    if r >= l:
        mid = (l+r) // 2
        if matrix[mid][0] <= target and matrix[mid][-1] >= target:
            return mid
        elif matrix[mid][0] > target:
            return binarySearchMatrix(matrix, l, mid-1, target)
        else:
            return binarySearchMatrix(matrix, mid+1, r, target)
    else:
        return -1
    
def binarySearchArray(arr, l, r, target):
    if r >= l:
        mid = (l+r) // 2
        if arr[mid] == target:
            return True
        elif arr[mid] > target:
            return binarySearchArray(arr, l, mid-1, target)
        else:
            return binarySearchArray(arr, mid+1, r, target)
    else:
         return False       

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0 or len(matrix[0]) == 0 or matrix[0][0] > target:
            return False
        
        row = binarySearchMatrix(matrix, 0, len(matrix)-1, target)
        if row == -1:
            return False
        else:
            return binarySearchArray(matrix[row], 0, len(matrix[0])-1, target)
        