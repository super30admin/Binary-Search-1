# Time: O(logk), k is possible index of target 
# space: O(1)
# Did this code run successfully on leetcode: yes
# Approach:
# increase the search space logarithmically starting from size 1 to size t in logt steps, by comparing target and right most element in the space.
# the search space will be of size t, to search this space binarily, logt.

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        left, right = 1, 1
        while target > reader.get(right - 1): # O(log(k)) k is target index
            left = right
            right <<= 1 # multiplying by 2 using bitwise shift, faster
            
        left -= 1; right -= 1 # making them 0 based indices
        # target index, if it exists, will be between this space
        while left <= right:
            # mid = (left + right) // 2, this expression can overflow when left and right are larger
            mid = left + ((right - left) >> 1) # halving by shift operation
            if target < reader.get(mid):
                right = mid - 1
            elif target == reader.get(mid):
                return mid
            else:
                left = mid + 1
        return -1