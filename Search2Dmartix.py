#Time Complexity : O(log(mn)) or O(logm) + O(logn) 
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: We treat the matrix as a 1D array and perform binary search on it. After calculating the mid, we find the index in
#the matrix using the formula r = mid//n and c = mid%n. once we find the row and column using the formula for the mid, we check
#if it is equal to target or no, and change the high and low pointer accordingly if not equal.


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix == None:
            return False
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m*n-1
        while low<=high:
            mid = (low+high) // 2
            r = mid // n
            c = mid % n
            if matrix[r][c] == target: return True
            elif matrix[r][c] > target:
                high = mid - 1
            else: low = mid + 1

        return False