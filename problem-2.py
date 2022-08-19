class Solution:
    def searchMatrix(self, matrix, target):
        def binarysearch(arr):
            left = 0
            right = len(arr) - 1
            if arr[left] == target or arr[right] == target:
                    return True
            while left<=right:
                mid = (left+right)//2
                if arr[mid] == target: return True
                elif target < arr[mid]: right = mid - 1
                else: left = mid + 1
            return False
                
        m = len(matrix)
        n = len(matrix[0])
        l, r = 0, n-1
        while l<m:
            left = matrix[l][0]
            right = matrix[l][r]
            if target >= left and target <= right:
                return(binarysearch(matrix[l]))
            if l+1 < m:
                if target > right and target < matrix[l+1][0]:
                    return False
            l += 1

obj = Solution()
print(obj.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]],3))