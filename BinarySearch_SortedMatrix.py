class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        lowrows = 0
        highrows = len(matrix)-1
        while lowrows<=highrows:
            mid = (lowrows+highrows)//2
            if matrix[mid][0] == target:
                return True
            elif matrix[mid][len(matrix[mid])-1] == target:
                return True
            elif matrix[mid][0] <= target and matrix[mid][len(matrix[mid])-1] >= target:
                return self.binarySearch(matrix[mid], target)
            elif matrix[mid][0] > target:
                highrows = mid-1
            elif matrix[mid][len(matrix[mid])-1] < target:
                lowrows = mid+1
        # for i in matrix:
        #     if i[0] <= target and i[len(i)-1] >= target:
        #         return self.binarySearch(i, target)
    
    def binarySearch(self, rowmatrix : list[int], target : int) -> bool:
        l = 0
        r = len(rowmatrix)-1
        
        while l<=r:
            mid = (l+r)//2
            if rowmatrix[mid] == target:
                return True
            elif rowmatrix[mid] <= target:
                l= mid+1
            else:
                r = mid-1
        if l > r:
            return False
        
"""In this implementation, we firstly do binary search and find in which row the target value exists, 
then do binary search on that particular row to trace the target value.
this approach takes O(log(n)+log(m)) time complexity if we have n*m matrix. O(log(n)) to find in which row the element might be present and
 O(log(m)) to do binary search on that particular row to find the target. """
        
        