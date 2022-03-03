# Search a 2D Matrix

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        #Brute Force
        # array_to_search = 0
        # for i in range(len(matrix)):
        #     if matrix[i][-1] >= target:
        #         array_to_search = i
        #         break

        # for number in matrix[array_to_search]:
        #     if number == target:
        #         return number == target

        # BTS

        # Time Complexity = O(logn) because of half size each time n/2+n/4+n/8+....
        # Space Complexity = O(1)

        # 3x3 [[1,2,3],[4,5,6],[7,8,9]]

        m = len(matrix)    #3
        n = len(matrix[0]) #3
        start = 0
        end = m*n -1       #9
        
        

        while start<=end:
            pivot_index = (start+end) // 2  # 4th position should be middle in first round
            pivot_element = matrix[pivot_index//n][pivot_index%n] # matrix[4//3 = 1][4%3 = 1]
            if pivot_element == target:
                return True
            else:
                if pivot_element > target:
                    end = pivot_index -1
                else:
                    start = pivot_index+1
        return False
            
            