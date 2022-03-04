#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO
class Solution:
    def search(self, arr: List[int], target: int) -> int:
        low = 0
        high = len(arr) - 1
        while low <= high:
            mid = low + (high - low) //2
            if arr[mid] == target:
                return mid
            
            if arr[low] <= arr[mid]:
                if arr[low] <= target and arr[mid] >= target:
                    high = mid - 1
                else:
                    low = mid + 1
            
            else:
                if arr[high] >= target and arr[mid] <= target:
                    low = mid + 1
                else:
                    high = mid - 1
            
        return -1