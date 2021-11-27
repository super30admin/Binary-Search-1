class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row = len(matrix)
        col = len(matrix[0])
        if row == 0:
            return False
        left = 0
        right = row*col - 1
        while left <= right:
            mid = (left + right) // 2
            mid_element = matrix[mid//col][mid % col]
            if mid_element == target:
                return True
            elif target < mid_element:
                right = mid - 1
            elif target > mid_element:
                left = mid+1
        return False

 '''
 Constructing a virtual arr that runs from indexes 0 to len(arr)-1
 then we do a binary search where mid = low + (high - low)//2
 mid element = arr[mid//col][mid%col]
 TIME COMPLEXITY = O(logN)
 '''
