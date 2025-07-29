class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # Time complexity - O(log n)
        # Space complexity - O(1)
        
        # maximum index of high can be 10000 since secret length constraints specify the max length
        # searching for nearest value of high to array length so range for array bounds is found
        # reduce high until it gets within actual array length using reader.get(mid) and reader.get(high)
        # once high found, search for target
        # any index >= actual length returns 2**31 - 1 from reader.get() => out of boundary
        # apply binary search to find target, if not exists return -1
    
        low = 0
        high = 10000
        mid = low + (high - low) // 2
        
        while reader.get(high) == 2**31 - 1  and reader.get(mid) == 2**31 - 1:
            high = mid
            mid = low + (high - low) // 2

        while low <= high:
            mid = low + (high - low) // 2
            val = reader.get(mid)

            if val == target:
                return mid
            elif val == 2**31 - 1 or val > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1
        
