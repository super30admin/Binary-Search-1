'''
Time Complexity - O(n)
Space Complexity - O(1)

No access to premium so haven't checked on Leetcode
'''
class Solution:
    def search(self, reader, target):
        low, high = 0, 1 #define low and high initially
        while reader.get(high) < target: #continue until the element of high is not greater than the target
            low = high #set low to current high
            high = 2 * high #update high to twice that of previous high
        while low <= high: #run binary search on the range we find
            mid = low + (high - low)//2
            if reader.get(mid) == target:
                return mid
            elif target > reader.get(mid):
                low = mid + 1
            else:
                high = mid - 1
        return -1