
# Time Complexity: O(log(n) + log(k)) where k is the size of the array where we found the element larger than the target
# Space Complexity: O(1) 
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l = 0
        r = 1
        i = 1
        while reader.get(r) < target:
            l = r
            r += i
            i *= 2
        while l <= r:
            mid = l + (r - l) // 2
            if reader.get(mid) == target:
                return mid
            
            if reader.get(mid) < target:
                l = mid + 1
            else:
                r = mid - 1
        
        return -
