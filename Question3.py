#Time-Complexity: O(logn)
#Space-Complexity: O(1)

def search(self, reader: 'ArrayReader', target: int) -> int:
        beg, end = 0, 10**4 - 1
        while beg <= end:
            mid = (beg + end) // 2
            val = reader.get(mid)
            if val == target:
                return mid
            # don't need it, 2**31 - 1 obviously bigger than target
            # if val == 2**31 - 1:
            #     end = mid - 1
            if val < target:
                beg = mid + 1
            else:
                end = mid - 1
        return -1
