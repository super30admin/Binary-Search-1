#Time Complexity: O(log n)
#Space Complexity: O(1)
#successfully ran on leetcode
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low=0
        high=1
        while reader.get(high)<target: # end of array is when target is smaller than high value
            low=high
            high=high*2
        while(low<=high): # when the mid is equal to low or high
            mid=low+(high-low)//2
            if reader.get(mid)==target:
                return mid
            elif reader.get(mid)<target and reader.get(high)>=target:
                    low=mid+1
            else:
                    high=mid-1
        return -1
