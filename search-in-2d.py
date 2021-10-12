def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

    rows = len(matrix)
    col = len(matrix[0])

    for i in range(rows):
        if target <= matrix[i][col-1]:
            if target > matrix[i][0]:

                start = 0
                end = col-1

                while start < end:
                    mid = start+end // 2
                    if matrix[i][mid] == target:
                        return True
                    elif matrix[i][mid] < target:
                        start = mid+1
                    else:
                        end = mid-1
                return False
