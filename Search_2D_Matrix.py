# Time Complexity : o(logn)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : Yes

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or target is None:
            return False
        r,c = len(matrix), len(matrix[0])
        l, h = 0, r*c -1    # assuming the matrix as an array, so total length can be r*c -1
        print(c)
        while(l<=h):
            mid = (l+h)//2
            num = matrix[mid//c][mid%c]        # mid//c gives the row, mid%c gives column
            if num == target:
                return True
            else:
                if target> num:
                    l = mid + 1
                else:
                    h = mid-1
        return False    