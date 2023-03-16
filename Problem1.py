class Solution(object):

    def binary_search(self, row, low, high, target):
        if high>=low:
            mid= low+ (high-low)//2
            if row[mid] == target:
                return True
            
            elif row[mid]> target:
                return self.binary_search(row, low, mid-1, target)
            else:
                return self.binary_search(row, mid+1, high, target)
            
        return False


    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        for i in matrix:
            if self.binary_search(i, 0, len(i)-1,target):
                return True
        return False

arr= [[1,3]]
obj= Solution()
obj.searchMatrix(arr, 3)