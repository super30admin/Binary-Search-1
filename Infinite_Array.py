#Time Complexity = 0(logn)
#Successfully compiled and run in Leetcode

class Solution:
    def search(self, reader, target):

        low = 0
        high = 1

        while (reader.get(high) < target): #loop until current val is greater than target - to find low & high boundary
            low = high
            high = high * 2 #exponential increment high val pointer

        #once interval of low and high boundary is found apply binary search
        while low <= high:
            mid = low + (high - low) // 2

            if (reader.get(mid) == target):
                return mid

            if (target > reader.get(mid)):
                low = mid + 1
            else:
                high = mid - 1

        return -1

