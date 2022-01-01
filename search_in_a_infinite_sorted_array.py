# Time Complexity : O(log N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Don't have leetcode premium so haven't tried
# Any problem you faced while coding this : nope
class Search(object):
    def fin(self, reader, target):
        low, high = 0, 1
        
        while(reader.get(high) >= target):
            if reader.get(high) == target: return high
            low = high
            high = high * 2
            
        while(low <= high):
            mid = low + high // 2
            if mid == target: return mid
        # mid is bigger than target
            if mid > target:
               high = mid - 1
            
        # mid is smaller than target
            if mid < target: 
               low = mid + 1
        return -1