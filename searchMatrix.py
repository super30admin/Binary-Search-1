# Brute Force Solution
# Time Complexity - O(N) as I am travesing all the elements of matrix and coping to another list
# Space Complexity - O(N) as I am using list as an extra space
 
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # Since the elements in each row is sorted and the first element of each row is greater than the last element of fprev row, 
        # I am flattening this 2D array into 1D
        # BRUTE FORCE 
        new_list = list()
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                new_list.append(matrix[i][j])

        # [1, 3, 5, 7, 10, 11, 16, 20, 23, 30, 34, 60]
        
        # Binary search
        low = 0
        high = len(new_list)-1

        while low <= high:
            mid = low + (high - low)//2
            if new_list[mid] > target:
                high = mid-1
            elif new_list[mid] < target:
                low = mid+1
            else:
                return True
        return False