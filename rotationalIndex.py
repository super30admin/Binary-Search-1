// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution:
    def find_pivot(self,arr):
        n = len(arr)
        start = 0
        end = len(arr) - 1
        if n == 1 or arr[0] < arr[n-1]:
            return -1
        
        while start <= end:
            mid = ( start + end ) // 2

        # base condition
            if end == start + 1 and arr[start] <= arr[end]:
                return end

            if arr[mid] > arr[mid+1]:
                 return mid

            elif arr[start] >= arr[mid]:
                end = mid - 1

            else:
                start = mid + 1


    def binary_search(self, arr,start , end , target):

        while start <= end:

            mid = ( start + end ) // 2
    

            if end > len(arr) or start < 0:
                return -1

            if arr[mid] == target:
                return mid
            elif arr[mid] >= target:
                end = mid - 1
            else:
                start = mid + 1

        return -1


    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        pivot = self.find_pivot(nums)

        if pivot == -1:
            return self.binary_search(nums, 0 , n - 1 , target)

        elif nums[0] > target:
            return self.binary_search(nums, pivot + 1 , n - 1,target)
        else:
            return self.binary_search(nums, 0 , pivot ,target)