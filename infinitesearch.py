class Solution(object):
    def search(self, reader, target):
        start, end = 0, 10**4-1
        outbound = 2147483647 
        while start <= end:
            mid = start + (end-start)/2
            midval = reader.get(mid)
            if midval == 2147483647 or midval > target:
                end = mid-1
            elif midval < target:
                start = mid + 1
            else:
                return mid
        return -1