# Time Complexity : O(log(m*n)) - binary search over all m*n elements as one sorted list
# Space Complexity : O(1) - only index variables are used
class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        m= len(matrix) #rows
        n = len(matrix[0]) #column
        low=0
        high =m*n-1
        while low<=high:
            mid = (low+high)//2
            r =mid//n
            c= mid%n
            midval=matrix[r][c]
            if midval==target:
                return True
            elif midval < target:
                low = mid+1
            else:
                high = mid-1
        return False