# Time complexity : O(log n)
# space complexity : O(1)
class Solution:
    def search(self, reader, target):
# initialize the start and end pointer at the 0 and 1 index       
        start = 0
        end = 1
# Limit the search space to less than target or array index out of bound
        while reader.get(end) < target and reader.get(end) < float('inf'):
# Perform reverse binary search by increasing the limit of binary search by twice iterratively        
                start = end
                end = 2*end
# binary search to chech if target is in current search space            
        while start <= end:
            mid = start + (end-start)//2
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) > target:
                end = mid-1
            else:
                start = mid+1
        return -1