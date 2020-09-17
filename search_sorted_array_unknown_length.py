# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:


# O(log(n)) average time complexity and O(n) worst case complexity
# O(1) space
class Solution:
    def search(self, reader, target):
        left = 0
        right = 1
        while target > reader.get(right):
            left = right
            right *= 2
        return self.binarySearch(reader,target,left,right)
    
    def binarySearch(self,reader,target,left,right):
        while left <= right:
            mid = (left + right) // 2
            if target == reader.get(mid):
                return mid
            if target < reader.get(mid):
                right = mid - 1
            else:
                left = mid + 1
        return -1
        