# Search in sorted array of unkown size
'''
Leetcode all test cases passed: Yes
Solution:
    Let n be the length of the array
    Space Complexity: O(1)
    search(self, arr, target):
        Time Complexity: O(log 10000) = O(13.287) = O(1)
    
'''


class Solution:

    def search(self, reader, target):
        l = 0
        r = 10000 - 1
        while l <= r:
            mid = (l + r) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                l = mid + 1
            else:
                r = mid - 1
        return -1
