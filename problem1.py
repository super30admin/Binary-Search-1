# Time Complexity : O(log(m)) if m> n else O(log(n))
# Space Complexity : O(m) if m>n else O(n) as storing row of the matrix.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        def getRow(m,target):
            # Return the appropriate row where the element might be present. 
            # Apply binary serach on the first column to achieve this.
            column = 0
            row_length = len(m)
            low = 0
            high = row_length-1
            while(low<=high):
                mid = (low+high) // 2
                if(m[mid][column] == target):
                    return m[mid]
                elif m[mid][column] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return m[high]
        
        def binarySearch(arr,target):
            # Apply binary Serach on the row returned as a result from getRow() Function.
            low = 0
            high = len(arr)-1
            while(low<=high):
                mid = (low + high) // 2
                if(arr[mid] == target):
                    return True
                elif arr[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return False
        row = getRow(matrix,target)
        return binarySearch(row,target)
