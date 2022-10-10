# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:


# Time Complexity: O((log(n))^2)
# Aproach: we set start = 0, left = 1 and keep doubling the size and check if in the
# new interval element is present or not using binary search.
# we terminate and return -1 if we have reached invalid values and not found the element still.
class Solution:
    def b_search(self,reader,start,end,target):
        answer = -1
        while start <= end:
            mid = (start + end) // 2
            if reader.get(mid) == target:
                answer = mid
                break
            elif reader.get(mid) > target:
                end = mid - 1
            else:
                start = mid + 1
        return answer
    def search(self, reader: 'ArrayReader', target: int) -> int:
        start = 0
        end = 1
        inv = (2**31) - 1
        answer = -1
        while reader.get(start) != inv :
            if self.b_search(reader,start,end,target) == -1:
                start = end
                end *= 2
            else:
                answer = self.b_search(reader,start,end,target)
                break
        return answer