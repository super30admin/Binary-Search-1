from typing import List
class Solution:
    def search_matrix(self, matrix: List[List[int]], target: int) -> bool:
        # rows
        m = len(matrix)
        # cols
        n = len(matrix[0])

        low = 0
        high = n*m - 1
        while low<=high:
            pivot_index = (low + high) //2 
            pivot_element_matrix = matrix[pivot_index//n][pivot_index%n]
            if pivot_element_matrix == target:
                return True
            elif target > pivot_element_matrix:
                low = pivot_index+1
            else:
                high = pivot_index -1
        return False

solution = Solution()
print(solution.search_matrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]],13))

            