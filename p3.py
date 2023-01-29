#time : logm + logn
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l = 0
        h = 1
        #this part takes logm time
        while (target > reader.get(h)):
                l = h
                h = h * 2

        #perform binary serach on the range:
       
       #this part takes logn time 
        while l <= h:
            mid = l + (h - l) // 2 # doing it this way so it doesn't go overflow -> negative value
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                h = mid - 1
            elif reader.get(mid) < target:
                l = mid + 1
        return -1