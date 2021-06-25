class Solution:

    def searchMatrix(self, matrix, target) :

        row = len(matrix)

        if row == 0:
            print ("No element")
        col = len(matrix[0])

        start = 0
        end = row * col - 1

        while row < col:

            mid = (start + end) // 2
            mid_val = matrix[mid // col][mid % col]

            if target == mid_val:
                return True

            else:
                if target < mid_val:
                    end = mid - 1
                else:
                    start = mid + 1
        return False


# s = Solution()
# matrix= [[1, 2, 3, 4], [5, 6, 7, 8]]
# s.searchMatrix(matrix, 2)