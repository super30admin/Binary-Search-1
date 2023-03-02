# Time complexity: O(log(mn))
# Space Complexity: O(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # Time complexity: O(Log(m*n))
        rowlen = len(matrix)
        collen = len(matrix[0])
        s = 0
        e = (rowlen * collen) - 1
        while s <= e:
            mid = (s + e) // 2
            currele = matrix[mid // collen][mid % collen]
            if target < currele:
                e = mid - 1
            elif target > currele:
                s = mid + 1
            else:
                return True
        return False
