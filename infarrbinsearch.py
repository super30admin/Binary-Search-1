# Time Complexity : O(logN) where N is the index of the target
# Space Complexity : O(1) as no extra space used
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, took me a little time to understand 
# the lapproach for this problem as well as the tume complexity for this problem

class InfArrayBinSearch:

    def infarrbinsearch(self, reader, target: int) -> int:
        if reader.get(0) == target:
            return 0

        left, right = 0, 1
        while reader.get(right) < target:
            left = right
            right = right << 1 
        
        while left <= right:
            mid = left + ((right - left) >> 1)
            num = reader.get(mid)
            if num == target:
                return mid
            elif target < num:
                right = mid - 1
            else:
                left = mid + 1
        return -1