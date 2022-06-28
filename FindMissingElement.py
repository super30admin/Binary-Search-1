class Solution:
    def missingElement(self, arr):

        low = 0
        high = len(arr) - 1

        while low <= high:
            mid = low + (high - low)//2
            if arr[mid] == mid + 1:
                if arr[mid+1] != arr[mid] + 1:
                    return arr[mid] + 1
                else:
                    low = mid + 1
            else:
                if arr[mid] != arr[mid-1] + 1:
                    return arr[mid-1] + 1
                else:
                    high = mid - 1
arr = [1,2,3,4,5,6,8]
s = Solution().missingElement(arr)
print(s)