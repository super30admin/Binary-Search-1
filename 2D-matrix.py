"""
Time Complexity: O(log)
Space Complexity: O(1)
Did your code run on leetcode? : yes
issues faced: 
"""
class Solution:
    def searchMatrix(self, matrix, target: int) -> bool:
        m = len(matrix[0])
        n = len(matrix)
        # print("m = ", m)
        # print("n = ", n)
        h = n*m -1
        l=0
        while(l<= h):
            mid = l + (h-l)//2
            # print("mid = ", mid)
            i = mid // m
            j = mid % m
            # print("i = ", i)
            # print("j = ", j)
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] > target:
                h = mid-1
            else:
                l = mid +1
        return False