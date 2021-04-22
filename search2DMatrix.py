class Solution:
    def searchMatrix(self,matrix,target):
        if len(matrix) > 0:
            for listiterator in matrix:
                if listiterator[0] <= target and listiterator[len(listiterator) - 1] >= target:
                    return self.binaryserach(listiterator, target)

            return False

    def binaryserach(self,matrix,target):
        left_ptr, right_ptr = 0, len(matrix) - 1
        while left_ptr <= right_ptr:
            mid = left_ptr + (right_ptr - left_ptr) // 2
            if matrix[mid] == target:
                return True
            if matrix[mid] < target:
                left_ptr = mid + 1
            else:
                right_ptr = mid - 1
        return False


#
# Runtime: 56 ms, faster than 11.13% of Python online submissions for Search a 2D Matrix.
# Memory Usage: 14.2 MB, less than 5.67% of Python online submissions for Search a 2D Matrix.

if __name__ == '__main__':
    matrix=[[1,3,5,7],[10,11,16,20],[23,30,34,60]]

    obj =Solution()
    print(obj.searchMatrix(matrix,target=13))




