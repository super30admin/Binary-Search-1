#Time complexity is O(logm + logn).

#SpaceComplexity is O(1).

#Approach: step1: performing binary search to find the array in which the target element will be presesnt if it is present in the given 2d array
#if array not found return false.
#step2: perform binary search on the 1d array, if the target is present it will true, else it will return false.






class Solution:
    def binarySearch(self, list, target):
        start = 0 
        end = len(list)-1
        while(start <= end ):
            mid = (start + end) //2
            if (list[mid] == target):
                return True
            elif (list[mid] > target):
                end = mid-1
            else:
                start = mid + 1
        return False
        
        
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])-1
        left = 0
        right = m-1
        
        while(left <= right):
            mid = (left +right )//2
            
            if (matrix[mid][n] == target):
                return True
            
            if(matrix[mid][n] > target):
                if matrix[mid][0] <= target:
                    return self.binarySearch(matrix[mid], target)
                else:
                    right = mid -1
                    
            elif(matrix[mid][n] < target):
                left = mid +1
        return False
