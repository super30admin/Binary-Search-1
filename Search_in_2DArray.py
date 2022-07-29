class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)-1
        n = len(matrix[0])-1
        left = 0
        right = n
        if m == 0:
            left = 0
            right = n
            while left <= right:
                mid = (left+right)//2
                if matrix[0][mid] == target:
                    return True
                elif matrix[0][mid]>target:
                    right = mid-1
                else:
                    left = mid+1
            return False
        elif n == 0:
            left = 0
            right = m
            while left <= right:
                mid = (left+right)//2
                if matrix[mid][0] == target:
                    return True
                elif matrix[mid][0]>target:
                    right = mid-1
                else:
                    left = mid+1
            return False
        else:
            left = 0
            right = m
            while left <= right:
                mid = (left+right)//2
                if matrix[mid][n] == target:
                    return True
                elif matrix[mid][n]>target and matrix[mid][0]<= target:
                    break;
                elif matrix[mid][n]>target:
                    right = mid-1
                else:
                    left = mid + 1
            if left > right:
                return False
            left = 0
            right = n
            while left <= right:
                mid1 = (left+right)//2
                if matrix[mid][mid1] == target:
                    return True
                elif matrix[mid][mid1] > target:
                    right = mid1 - 1
                else:
                    left = mid1 + 1
            return False
            
            
        