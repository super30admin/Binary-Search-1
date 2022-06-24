"""
TC:O(log(mn))
SC:O(1)
"""

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = (m*n)-1
        mid = int((low+high)/2)
        pri_loc=int(mid/n)
        sec_loc=int(mid%n)
        while low <= high:
            if target > matrix[pri_loc][sec_loc]:
                low = mid + 1
                mid = int((low+high)/2)
                pri_loc=int(mid/n)
                sec_loc=int(mid%n)
            elif target < matrix[pri_loc][sec_loc]:
                high = mid -1
                mid = int((low+high)/2)
                pri_loc=int(mid/n)
                sec_loc=int(mid%n)
            elif matrix[pri_loc][sec_loc]==target:
                return True
            else:
                return False
