# Search in rotated sorted array
'''
Leetcode all test cases passed: Yes
Solution:
    Let n be the length of the array
    Space Complexity: O(1)
    search(self, arr, target):
        Time Complexity: O(log n)
    
'''


class Solution:

    def search(self, arr, target):
        l = 0
        r = len(arr) - 1
        while l <= r:

            mid = (l + r) // 2
            if arr[mid] == target:
                return mid
            if target < arr[mid]:
                if target <= arr[r] < arr[mid]:
                    l = mid + 1
                else:
                    r = mid - 1
            else:
                if arr[mid] < arr[l] <= target:
                    r = mid - 1
                else:
                    l = mid + 1

        return -1
