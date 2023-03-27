#we are using reader to read the values
# main part is to get high and low values. using iternative method we are getting the high and low values
# then binary search

#tc: o(nlogn)
#sc: 0(1)

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high = high * 2
        return self.binarysearch(reader, target, low, high)

    def binarysearch(self, reader: 'ArrayReader', target: int, low: int, high: int):
        while low <= high:
            mid = (low + high) // 2

            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1