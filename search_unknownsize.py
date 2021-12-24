#We do not know the size of the array. So increase the search space by 2x until it's value becomes greater than the target. 
#Then, perform binary search. Since any out of bound value will return infinity, no special case need to be hanfled.
class Solution:
    def search(self, reader, target):
        low = 0
        high = 1
        while (reader.get(high) < target):            
            low = high
            high = high * 2
        while (low<=high):
            mid = low + (high-low)//2
            if reader.get(mid) == target:
                return mid
            elif (reader.get(mid) < target):
                low = mid+1
            else:
                high = mid-1
        return -1

#Time Complexity: O(LogN)
#Compiled in Leetcode