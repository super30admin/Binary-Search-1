class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        
        low = 0
        high = m*n - 1
        while low <= high:
            mid = (low+high)//2
            ele = matrix[mid//n][mid % n]
            if target == ele:
                return True
            else:
                if target < ele:
                    high = mid - 1
                else:
                    low = mid + 1
        return False
''''
Test cases passed on LeetCode
Time Complexity : O(log(mn)) -- Binary Search
Space Complexity : O(1)
'''
