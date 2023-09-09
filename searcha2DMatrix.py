# Time Complexity : O(log(m*n))
# Space Complexity : O(1)

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if matrix == None:
            return False
        m , n = len(matrix), len(matrix[0])
        low, high = 0, m*n-1
        while low<=high:
            mid = (low+high) // 2
            r = mid // n
            c = mid % n
            if matrix[r][c] == target: return True
            elif matrix[r][c] > target:
                high = mid - 1
            else: low = mid + 1

        return False


        
