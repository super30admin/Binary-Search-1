class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        #edge case
        if len(matrix) == 0:
            return False


        row_num = len(matrix) #3
        col_num = len(matrix[0]) # 4
        arr_size = row_num * col_num #12

        l = 0
        h = arr_size - 1 

        while l <= h:
            mid = (l + h) // 2 # 12 //2 = 6
            #to locate the box
            row_index = mid // col_num  # 6 // 4 = 1
            col_index = mid % col_num # 6 % 4 = 2
            box = matrix[row_index][col_index]
            if target == box:
                return True
            elif target < box:
                h = mid - 1
            elif target > box:
                l = mid + 1
        return False