# Time Complexity : O(log*n) + O(log*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
# first find the pivot element and then set the start and end pointers according to it
# and then do the binary search

class Solution:
    def binarySearch(self, arr, start, end, target):
        while start <= end:
            mid = start + (end - start)//2
            if arr[mid] == target:
                return mid
            elif target > arr[mid]:
                start = mid + 1
            else:
                end = mid - 1
        return -1

    def pivot(self, arr):
        start = 0
        end = len(arr) - 1
        while start <= end:
            mid = start + (end-start)//2
            if arr[mid] < arr[mid-1]:
                return mid
            elif arr[mid] < arr[end]:
                end = mid - 1
            elif arr[start] <= arr[mid]:
                start = mid + 1

    def search(self, arr, target):
        if arr[0] <= arr[-1]:
            return self.binarySearch(arr, 0, len(arr)-1, target)
        pivot_index = self.pivot(arr)
        start = 0
        end = len(arr) - 1
        if target < arr[start]:
            start = pivot_index
        else:
            end = pivot_index - 1
        result = self.binarySearch(arr, start, end, target)
        return result


rotated = Solution()
print(rotated.search([4, 5, 6, 7, 8, 0, 1, 2], 0))
