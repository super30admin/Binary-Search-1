from typing import List

class Solution:

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low = 0
        high = len(matrix) * len(matrix[0]) - 1
        n = len(matrix[0])
        while low <= high:
            mid = low + ((high - low) // 2)
            row = mid // n
            col = mid % n
            if matrix[row][col] == target: 
                return True
            
            if matrix[row][col] < target:
                low = mid + 1
            else:
                high = mid - 1
                
        return False
    
    # def binarySearch(self, arr: List[int], target: int) -> bool:
    #     low = 0
    #     high = len(arr) - 1
        
    #     while low <= high:
    #         mid = low + ((high - low) // 2)
            
    #         if arr[mid] == target: 
    #             return True
            
    #         if arr[mid] < target:
    #             low = mid + 1
    #         else:
    #             high = mid - 1
                
    #     return False
                
    # def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    #     low = 0
    #     high = len(matrix) - 1
    #     col = len(matrix[0]) - 1
    #     while low <= high:
    #         mid = low + ((high - low) // 2)
            
    #         if (target >= matrix[mid][0] and target <= matrix[mid][col]):
    #             return self.binarySearch(matrix[mid],target)
            
    #         if target < matrix[mid][0]:
    #             high = mid -1
    #         else:
    #             low = mid + 1
                
    #     return False

obj = Solution()
print(obj.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]],3))
print(obj.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]],13))


# Time Complexity : O(log(n)) + O(log(m))
# where n and m are number of rows and cols
# Space Complexity: O(1)
