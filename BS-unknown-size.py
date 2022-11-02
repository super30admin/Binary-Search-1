# <!-- // Time Complexity : O(logn + log n) == O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : -->
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l = 0
        r = 1
        while target>reader.get(r):
            l = r + 1
            r <<= 1
            # print(r, l)
        while l<=r:
            mid = l + (r - l)//2
            # print(mid,"mid")
            if reader.get(mid)==target:
                return mid
            elif reader.get(mid)>target:
                r = mid - 1
            elif reader.get(mid)<target:
                l = mid + 1
        return -1
#         f = 0
#         l = 10000
#         while f<=l:
#             mid = (f+l)//2
#             if reader.get(mid)==target:
#                 return mid
#             elif reader.get(mid)>target:
#                 l = mid - 1
#             elif reader.get(mid)<target:
#                 r = mid + 1
#         return -1
        