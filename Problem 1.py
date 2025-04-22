class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS, COLS = len(matrix)-1, len(matrix[0])-1
        #vertical bsearch on rows
        up, down = 0, ROWS

        while up <= down:
            mid = (up + down)//2

            if matrix[mid][COLS] == target:
                return True
            
            if matrix[mid][0] > target:
                # if matrix[mid][0] <= target < matrix[mid][COLS]:
                #     break
                # else:
                down = mid - 1
            else:
                # if matrix[mid][0] <= target < matrix[mid][COLS]:
                #     break
                # else:
                up = mid + 1
        
        left, right = 0, COLS
        arr = matrix[up - 1] #matrix[mid]
        while left <= right:
            mid = (left + right)//2

            if arr[mid] == target:
                return True
            
            if arr[mid] < target:
                left = mid + 1
            else:
                right = mid - 1

        return False


