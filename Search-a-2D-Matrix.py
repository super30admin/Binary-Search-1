# Reference link: https://youtu.be/TXfCukv3I9E
#steps
#convert it to a linear array from 0 to 11 index
# middle element 5 (0+11/2)
#to get position of 5 from the 2D matrix, matrix[5//4] [5%4]
#perform binary search iteratively
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        
        left = 0
        right = m * n - 1
        
        while (left <= right):
            mid = (left + right) //2
            mid_of_mid = matrix[mid // n][mid % n]
            if mid_of_mid == target:
                return True
            elif target < mid_of_mid:
                right = mid - 1
            else:
                left = mid + 1
        return False


#Time Complexity - O(log(mn))
#Space Complexity - O(1)           