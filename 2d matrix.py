#time complexity - O(log(mn))
#space complexity - O(1)
#solution ran on leetcode successfully
#no problems during coding


def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows, cols = len(matrix), len(matrix[0])
        rowmin, rowmax = 0, rows-1
		# Binary Search along rows
        while (rowmin <= rowmax and rowmax >= 0 and rowmin <= rows-1):
            r = (rowmin + rowmax) // 2
            if target < matrix[r][0]:
                rowmax = r-1
            elif target > matrix[r][cols-1]:
                rowmin = r+1
            else:
                colmin, colmax = 0, cols-1
				# Binary search along columns
                while(colmin <= colmax and colmax >= 0 and colmin <= cols-1):
                    c = (colmin + colmax) // 2
                    if target == matrix[r][c]:
                        return True
                    elif target < matrix[r][c]:
                        colmax = c-1
                    else:
                        colmin = c+1
                return False
        return False