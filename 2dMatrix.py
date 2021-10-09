# Time Complexity: O(n + log m)
# Space Complexity: O(1)

class Solution:
    def binarySearch(self,arr,target):
        start, last = 0, len(arr)-1
        mid = (len(arr)-1)//2

        if target in [arr[start], arr[last]]:
            return True
        
        while start <= last:
            if target == arr[mid]:
                return True
            elif target > arr[mid]:
                start = mid + 1
            else:
                last = mid - 1
            mid = (start+last)//2
        return False
        

    def searchMatrix(self, matrix, target) -> bool:
        if len(matrix) == 0 or matrix[0][0] > target:
            return False

        for i in matrix:
            if i[0] <= target <= i[-1]:
                res = self.binarySearch(i, target)
                return res
        return False


obj = Solution()
print(obj.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 13))