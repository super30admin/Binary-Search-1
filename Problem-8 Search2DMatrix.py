# 74. Search a 2D Matrix

# Time Complexity: O(log(mn))
# Space Complexity: O(1)

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        
        l = 0
        h = len(matrix) * len(matrix[0]) - 1

        while l <= h:
            mid = l + (h-l) //2

            r = mid/len(matrix[0])
            c = mid%len(matrix[0])

            if(matrix[r][c] == target):
                return True
            elif(matrix[r][c] > target):
                h = mid - 1
            else:
                l = mid + 1
        return False