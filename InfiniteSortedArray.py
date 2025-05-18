#Time Complexity :O(logn)
#Space Complexity : O(1)
#Any problem you faced while coding this : No
#Approach: Using binary search, double my high pointer every time if the target is grater than High.

class Solution:
    def search(self, reader, target):
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high = 2 * high
        while low <= high:
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1   
        return -1


