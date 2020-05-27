# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
class Solution(object):
    def search(self, nums, target):
        return self.binarySearch(nums, 0, len(nums) - 1, target)


    def binarySearch(self, arr, left, right, x):
        if left <= right:
            mid = left + (right - left) / 2
            if x == arr[mid]:
                return mid
            elif x < arr[mid]:
                if arr[left] <= x < arr[mid]:
                    return self.binarySearch(arr, left, mid-1, x)
                else:
                    return self.binarySearch(arr, mid+1, right, x)
            elif x > arr[mid]:
                if arr[right] >= x > arr[mid]:
                    return self.binarySearch(arr, mid+1, right, x)
                else:
                    return self.binarySearch(arr, left, mid-1, x)
        return -1

nums = [4, 5, 6, 7, 0, 1, 2]
target = 4
s = Solution()
print s.search(nums, target)
