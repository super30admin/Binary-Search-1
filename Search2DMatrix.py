'''
Time Complexity: 
Space Complexity:
Leetcode: Unsucessful
Problems: I understood the logic but found it hard to code it
'''

class Solution:
    def searchMatrix(self, matrix, target) -> bool:
        n = len(matrix)
        m = len(matrix[0])

        low = 0
        high = n * m -1
        while low<=high:
            mid = low + (high - low)//2

            i = mid/m
            j = mid%m
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] < target:
                low = mid + 1
            else:
                high = mid - 1
        return False


s = Solution()
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 3
s.searchMatrix(matrix,target)
